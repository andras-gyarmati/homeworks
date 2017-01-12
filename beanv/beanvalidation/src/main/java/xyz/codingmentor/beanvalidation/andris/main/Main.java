package xyz.codingmentor.beanvalidation.andris.main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.beanvalidation.andris.service.Cart;
import xyz.codingmentor.beanvalidation.andris.database.DeviceDB;
import xyz.codingmentor.beanvalidation.andris.bean.DeviceEntity;
import xyz.codingmentor.beanvalidation.andris.database.UserDB;
import xyz.codingmentor.beanvalidation.andris.bean.UserEntity;

/**
 *
 * @author brianelete
 */
public class Main {

    private Main() {
        //empty
    }
    private static Weld weld;
    private static WeldContainer container;
    private static UserDB userDB;
    private static DeviceDB deviceDB;
    private static Cart cart;

    public static void main(String[] args) throws IOException {
        weld = new Weld();
        container = weld.initialize();
        Logger LOGGER = Logger.getLogger(Main.class.getName());
        try {
            readUsersFromJson("json/users.json");
            readDevicesFromJson("json/devices.json");
//            readUsersFromJson("json/invalidUsers.json");
//            readDevicesFromJson("json/invalidDevices.json");
            cart = container.instance().select(Cart.class).get();
            List<DeviceEntity> devices = deviceDB.getAllDevice();
            DeviceEntity deviceToBuy = devices.get(0);
            deviceToBuy.setCount(10);
            cart.addDevice(deviceToBuy, 3);
            cart.removeDevice(deviceToBuy, 1);
            cart.removeAll();
            cart.addDevice(deviceToBuy, 2);
            LOGGER.log(Level.INFO, "Total pice: " + cart.getPrice());
            cart.buy();
        } catch (Exception e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
        weld.shutdown();
    }

    private static void readUsersFromJson(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserEntity> users = mapper.readValue(new File(filename), new TypeReference<List<UserEntity>>() {
        });
        userDB = container.instance().select(UserDB.class).get();
        for (UserEntity user : users) {
            userDB.addUser(user);
        }
    }

    private static void readDevicesFromJson(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<DeviceEntity> devices = mapper.readValue(new File(filename), new TypeReference<List<DeviceEntity>>() {
        });
        deviceDB = container.instance().select(DeviceDB.class).get();
        for (DeviceEntity device : devices) {
            deviceDB.addDevice(device);
        }
    }
}

package xyz.codingmentor.andris.webshop.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import xyz.codingmentor.andris.webshop.bean.DeviceEntity;
import xyz.codingmentor.andris.webshop.bean.UserEntity;
import xyz.codingmentor.andris.webshop.database.DeviceDB;
import xyz.codingmentor.andris.webshop.database.UserDB;

/**
 *
 * @author brianelete
 */
@Singleton
@Startup
public class CacheEJB {

    @EJB
    private UserDB userDB;
    @EJB
    private DeviceDB deviceDB;

    private static final Logger LOGGER = Logger.getLogger(CacheEJB.class.getName());

    @PostConstruct
    void init() {
        try {
            readUsersFromJson("users.json");
            readDevicesFromJson("devices.json");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    private void readUsersFromJson(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserEntity> users = mapper.readValue(new File(getClass().getClassLoader().getResource(filename).getFile()), new TypeReference<List<UserEntity>>() {
        });
        for (UserEntity user : users) {
            userDB.addUser(user);
        }
    }

    private void readDevicesFromJson(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<DeviceEntity> devices = mapper.readValue(new File(getClass().getClassLoader().getResource(filename).getFile()), new TypeReference<List<DeviceEntity>>() {
        });
        int count;
        for (DeviceEntity device : devices) {
            count = device.getCount();
            deviceDB.addDevice(device);
            device.setCount(count);
        }
    }
}

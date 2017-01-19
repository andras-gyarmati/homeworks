package xyz.codingmentor.andris.webshop.bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.andris.webshop.database.DeviceDB;
import xyz.codingmentor.andris.webshop.database.UserDB;

/**
 *
 * @author brianelete
 */
@Singleton
@Startup
public class CacheEJB {

    @Inject
    private UserDB userDB;
    @Inject
    private DeviceDB deviceDB;
    
     private static final Logger LOGGER = Logger.getLogger(CacheEJB.class.getName());

    @PostConstruct
    void init() {
        try {
            readUsersFromJson("json/users.json");
            readDevicesFromJson("json/devices.json");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    private void readUsersFromJson(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserEntity> users = mapper.readValue(new File(filename), new TypeReference<List<UserEntity>>() {
        });
        for (UserEntity user : users) {
            userDB.addUser(user);
        }
    }

    private void readDevicesFromJson(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<DeviceEntity> devices = mapper.readValue(new File(filename), new TypeReference<List<DeviceEntity>>() {
        });
        for (DeviceEntity device : devices) {
            deviceDB.addDevice(device);
        }
    }
}

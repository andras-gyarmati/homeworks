package xyz.codingmentor.beanvalidation.andris.main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import xyz.codingmentor.beanvalidation.andris.beans.DeviceDB;
import xyz.codingmentor.beanvalidation.andris.beans.DeviceEntity;
import xyz.codingmentor.beanvalidation.andris.beans.UserDB;
import xyz.codingmentor.beanvalidation.andris.beans.UserEntity;

/**
 *
 * @author brianelete
 */
public class Main {

    private Main() {
        //empty
    }

    public static void main(String[] args) throws IOException {
        readUsersFromJson();
        readDevicesFromJson();
    }

    private static void readUsersFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserEntity> users = mapper.readValue(new File("users.json"), new TypeReference<List<UserEntity>>() {
        });
        UserDB userDB = new UserDB();

        for (UserEntity user : users) {
            userDB.addUser(user);
        }
    }

    private static void readDevicesFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<DeviceEntity> devices = mapper.readValue(new File("devices.json"), new TypeReference<List<DeviceEntity>>() {
        });
        DeviceDB deviceDB = new DeviceDB();

        for (DeviceEntity device : devices) {
            deviceDB.addDevice(device);
        }
    }

}

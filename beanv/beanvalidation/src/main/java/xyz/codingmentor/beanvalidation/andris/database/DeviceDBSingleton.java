package xyz.codingmentor.beanvalidation.andris.database;

import java.io.IOException;
import xyz.codingmentor.beanvalidation.andris.exception.DeviceNotFoundException;
import xyz.codingmentor.beanvalidation.andris.exception.DeviceAlreadyStoredException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import xyz.codingmentor.beanvalidation.andris.bean.DeviceEntity;

/**
 *
 * @author brianelete
 */
public enum DeviceDBSingleton {

    INSTANCE;

    private final Map<String, DeviceEntity> devices = new HashMap<>();

    public void addDevice(DeviceEntity device) {
        if (null != devices.get(device.getId())) {
            throw new DeviceAlreadyStoredException("Error! Already stored item.");
        }
        device.setId(UUID.randomUUID().toString());
        device.setCount(0);
        this.devices.put(device.getId(), device);
    }

    public DeviceEntity editDevice(DeviceEntity device) {
        if (null == devices.get(device.getId())) {
            throw new DeviceNotFoundException("Error! Device: " + device.getId() + " is can not be found!");
        }
        this.devices.put(device.getId(), device);
        return getDevice(device.getId());
    }

    public DeviceEntity getDevice(String id) {
        if (null == devices.get(id)) {
            throw new DeviceNotFoundException("Error! Device: " + id + " is can not be found!");
        }
        return devices.get(id);
    }

    public DeviceEntity deleteDevice(DeviceEntity device) {
        DeviceEntity deletedDevice = getDevice(device.getId());
        devices.remove(device.getId());
        return deletedDevice;
    }

    public List<DeviceEntity> getAllDevice() {
        return new ArrayList(devices.values());
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        //sonar
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        //sonar
    }
}

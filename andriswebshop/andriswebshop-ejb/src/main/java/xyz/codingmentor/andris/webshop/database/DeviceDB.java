    package xyz.codingmentor.andris.webshop.database;

import xyz.codingmentor.andris.webshop.exceptions.DeviceAlreadyStoredException;
import xyz.codingmentor.andris.webshop.exceptions.DeviceNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.andris.webshop.bean.DeviceEntity;
import xyz.codingmentor.andris.webshop.interceptor.ValidatorInterceptor;

/**
 *
 * @author brianelete
 */
@Singleton
@Interceptors(ValidatorInterceptor.class)
public class DeviceDB {

    private static final Map<String, DeviceEntity> DEVICES = new HashMap<>();
    
    @ExcludeClassInterceptors
    public void addDevice(DeviceEntity device) {
        if (null != DEVICES.get(device.getId())) {
            throw new DeviceAlreadyStoredException("Error! Already stored item.");
        }
        device.setId(UUID.randomUUID().toString());
        device.setCount(0);
        DEVICES.put(device.getId(), device);
    }

    public DeviceEntity editDevice(DeviceEntity device) {
        if (null == DEVICES.get(device.getId())) {
            throw new DeviceNotFoundException("Error! Device: " + device.getId() + " is can not be found!");
        }
        DEVICES.put(device.getId(), device);
        return getDevice(device.getId());
    }

    public DeviceEntity getDevice(String id) {
        if (null == DEVICES.get(id)) {
            throw new DeviceNotFoundException("Error! Device: " + id + " is can not be found!");
        }
        return DEVICES.get(id);
    }

    public DeviceEntity deleteDevice(DeviceEntity device) {
        DeviceEntity deletedDevice = getDevice(device.getId());
        DEVICES.remove(device.getId());
        return deletedDevice;
    }

    public List<DeviceEntity> getAllDevice() {
        List<DeviceEntity> deviceList = new ArrayList();
        deviceList.addAll(DEVICES.values());
        return deviceList;
    }
}

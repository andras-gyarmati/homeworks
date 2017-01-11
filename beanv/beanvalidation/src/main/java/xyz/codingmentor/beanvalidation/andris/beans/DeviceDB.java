package xyz.codingmentor.beanvalidation.andris.beans;

import xyz.codingmentor.beanvalidation.andris.exception.DeviceAlreadyStoredException;
import xyz.codingmentor.beanvalidation.andris.exception.DeviceNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.beanvalidation.andris.interceptor.BeanValidation;
import xyz.codingmentor.beanvalidation.andris.interceptor.ValidatorInterceptor;

/**
 *
 * @author brianelete
 */
//@BeanValidation
@Interceptors(ValidatorInterceptor.class)
public class DeviceDB {

    private Map<String, DeviceEntity> devices = new HashMap<>();

    @ExcludeClassInterceptors
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
        List<DeviceEntity> deviceList = new ArrayList();
        deviceList.addAll(devices.values());
        return deviceList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.devices);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeviceDB other = (DeviceDB) obj;
        if (!Objects.equals(this.devices, other.devices)) {
            return false;
        }
        return true;
    }

}

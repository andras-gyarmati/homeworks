package xyz.codingmentor.beanvalidation.andris.beans;

/**
 *
 * @author brianelete
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

public class DeviceDB {

    private Map<String, DeviceEntity> devices = new HashMap<>();

    public void addDevice(DeviceEntity device) {
        if (null != devices.get(device.getId())) {
            throw new IllegalArgumentException("Error! Already stored item.");
        }
        device.setId(UUID.randomUUID().toString());
        device.setCount(0);
        this.devices.put(device.getId(), device);
    }

    public DeviceEntity editDevice(DeviceEntity device) {
        if (null == devices.get(device.getId())) {
            throw new NoSuchElementException();
        }
        this.devices.put(device.getId(), device);
        return getDevice(device.getId());
    }

    public DeviceEntity getDevice(String id) {
        if (null == devices.get(id)) {
            throw new NoSuchElementException();
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

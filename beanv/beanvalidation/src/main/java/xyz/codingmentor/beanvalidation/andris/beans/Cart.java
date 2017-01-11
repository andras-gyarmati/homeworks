package xyz.codingmentor.beanvalidation.andris.beans;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author brianelete
 */
public class Cart {

    @Inject
    private Logger logger;
    @Inject @Singleton
    DeviceDB deviceDB;

    private int price;

    Map<String, DeviceEntity> devices = new HashMap<>();

    public void addDevice(DeviceEntity device, int count) {
        if (count <= deviceDB.getDevice(device.getId()).getCount()) {
            DeviceEntity addedDevice = device;
            addedDevice.setCount(count);
            deviceDB.getDevice(device.getId()).setCount(deviceDB.getDevice(device.getId()).getCount() - count);
            devices.put(device.getId(), device);
            price += device.getPrice() * count;
        }
    }

    public void removeDevice(DeviceEntity device, int count) {
        if (count == devices.get(device.getId()).getCount()) { //harmadik esetet elore exceptionn-el és a közöseket utána ki lehet emelni?
            devices.remove(device.getId());
            deviceDB.getDevice(device.getId()).setCount(deviceDB.getDevice(device.getId()).getCount() + count);
            price -= device.getPrice() * count;
        } else if (count < devices.get(device.getId()).getCount()) {
            devices.get(device.getId()).setCount(devices.get(device.getId()).getCount() - count);
            deviceDB.getDevice(device.getId()).setCount(deviceDB.getDevice(device.getId()).getCount() + count);
            price -= device.getPrice() * count;
        }
    }

    public void removeAll() {
        List<DeviceEntity> deviceList = new ArrayList(this.devices.values());
        for (DeviceEntity device : deviceList) {
            removeDevice(device, device.getCount());
        }
    }

    public int getPrice() {
        return price;
    }

    public void buy() {
        logger.log(Level.INFO, "You have successfully purchased theese devices:");
        List<DeviceEntity> deviceList = new ArrayList(this.devices.values());
        for (DeviceEntity device : deviceList) {
            logger.log(Level.INFO, "{0} count: {1} price: {2}", new Object[]{device.toString(), device.getCount(), device.getCount() * device.getPrice()});
        }
        this.devices.clear();
    }
}

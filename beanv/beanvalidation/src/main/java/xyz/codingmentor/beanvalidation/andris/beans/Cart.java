package xyz.codingmentor.beanvalidation.andris.beans;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;
import xyz.codingmentor.beanvalidation.andris.exception.DemandedQuantityIsNotAvailableException;

/**
 *
 * @author brianelete
 */
public class Cart {

    private static final Logger LOGGER = Logger.getLogger(Cart.class.getName());
    @Inject
    @Singleton
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
            LOGGER.log(Level.INFO, "{0} added, count: {1} price: {2}", new Object[]{device.toString(), device.getCount(), device.getCount() * device.getPrice()});
        }
    }

    public void removeDevice(DeviceEntity device, int count) {
        if (count > devices.get(device.getId()).getCount()) {
            throw new DemandedQuantityIsNotAvailableException("The demanded quantity is not available!");
        } else if (count == devices.get(device.getId()).getCount()) {
            devices.remove(device.getId());
        } else if (count < devices.get(device.getId()).getCount()) {
            devices.get(device.getId()).setCount(devices.get(device.getId()).getCount() - count);
        }
        deviceDB.getDevice(device.getId()).setCount(deviceDB.getDevice(device.getId()).getCount() + count);
        price -= device.getPrice() * count;
        LOGGER.log(Level.INFO, "{0} removed, count: {1} price: {2}", new Object[]{device.toString(), device.getCount(), device.getCount() * device.getPrice()});
    }

    public void removeAll() {
        List<DeviceEntity> deviceList = new ArrayList(this.devices.values());
        for (DeviceEntity device : deviceList) {
            removeDevice(device, device.getCount());
            LOGGER.log(Level.INFO, "{0} removed, count: {1} price: {2}", new Object[]{device.toString(), device.getCount(), device.getCount() * device.getPrice()});
        }
    }

    public int getPrice() {
        return price;
    }

    public void buy() {
        LOGGER.log(Level.INFO, "You have successfully purchased theese devices:");
        List<DeviceEntity> deviceList = new ArrayList(this.devices.values());
        for (DeviceEntity device : deviceList) {
            LOGGER.log(Level.INFO, "{0} count: {1} price: {2}", new Object[]{device.toString(), device.getCount(), device.getCount() * device.getPrice()});
        }
        this.devices.clear();
    }
}

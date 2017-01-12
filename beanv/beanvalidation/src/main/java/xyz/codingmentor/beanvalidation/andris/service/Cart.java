package xyz.codingmentor.beanvalidation.andris.service;

import xyz.codingmentor.beanvalidation.andris.database.DeviceDBSingleton;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.beanvalidation.andris.bean.DeviceEntity;
import xyz.codingmentor.beanvalidation.andris.exception.AmountInCartIsLessThanRemovableAmountException;

/**
 *
 * @author brianelete
 */
public class Cart {

    private static final Logger LOGGER = Logger.getLogger(Cart.class.getName());

    DeviceDBSingleton deviceDB = DeviceDBSingleton.INSTANCE;

    private int price;

    Map<String, DeviceEntity> devices = new HashMap<>();

    public void addDevice(DeviceEntity device, int count) {
        if (count <= deviceDB.getDevice(device.getId()).getCount()) {
            DeviceEntity addedDevice = new DeviceEntity(null, device.getManufacturer(), device.getType(), device.getPrice(), device.getColor(), count);
            addedDevice.setId(device.getId());
            device.setCount(device.getCount() - count);
            devices.put(addedDevice.getId(), addedDevice);
            price += addedDevice.getPrice() * count;
            LOGGER.log(Level.INFO, "{0} added, count: {1} price: {2}", new Object[]{addedDevice.toString(), addedDevice.getCount(), addedDevice.getCount() * addedDevice.getPrice()});
        }
    }

    public void removeDevice(DeviceEntity device, int count) {
        if (count > devices.get(device.getId()).getCount()) {
            throw new AmountInCartIsLessThanRemovableAmountException("The amount of devices in the cart is less than you want to remove!");
        } else if (count == devices.get(device.getId()).getCount()) {
            devices.remove(device.getId());
        } else if (count < devices.get(device.getId()).getCount()) {
            devices.get(device.getId()).setCount(devices.get(device.getId()).getCount() - count);
        }
        deviceDB.getDevice(device.getId()).setCount(deviceDB.getDevice(device.getId()).getCount() + count);
        price -= device.getPrice() * count;
        LOGGER.log(Level.INFO, "{0} removed, count: {1} price: {2}", new Object[]{device.toString(), count, count * device.getPrice()});
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
        if (0 == devices.size()) {
            LOGGER.log(Level.INFO, "Your cart is empty!");
        } else {
            for (DeviceEntity device : devices.values()) {
                if (0 != device.getCount()) {
                    LOGGER.log(Level.INFO, "Purchased: {0} count: {1} price: {2}", new Object[]{device.toString(), device.getCount(), device.getCount() * device.getPrice()});
                }
                this.devices.clear();
            }
        }
    }
}

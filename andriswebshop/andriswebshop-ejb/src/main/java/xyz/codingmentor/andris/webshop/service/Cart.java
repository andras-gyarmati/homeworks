package xyz.codingmentor.andris.webshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import xyz.codingmentor.andris.webshop.bean.DeviceEntity;
import xyz.codingmentor.andris.webshop.database.DeviceDB;
import xyz.codingmentor.andris.webshop.exceptions.WrongAmountException;

/**
 *
 * @author brianelete
 */
@Stateful
public class Cart {

    private static final Logger LOGGER = Logger.getLogger(Cart.class.getName());

    private final DeviceDB deviceDB;

    private int totalPrice;

    Map<String, DeviceEntity> devices = new HashMap<>();

    public Cart() {
        this.deviceDB = DeviceDB.getInstance();
    }

    public List<DeviceEntity> addDevice(DeviceEntity device, int count) {
        if (count <= deviceDB.getDevice(device.getId()).getCount()) {
            DeviceEntity addedDevice = new DeviceEntity(null, device.getManufacturer(), device.getType(), device.getPrice(), device.getColor(), count);
            addedDevice.setId(device.getId());
            device.setCount(device.getCount() - count);
            devices.put(addedDevice.getId(), addedDevice);
            totalPrice += addedDevice.getPrice() * count;
            LOGGER.log(Level.INFO, "{0} added, count: {1} price: {2}", new Object[]{addedDevice.toString(), addedDevice.getCount(), addedDevice.getCount() * addedDevice.getPrice()});
        } else {
            throw new WrongAmountException("The amount of devices in the database is less than you want to add!");
        }
        return getAllDevices();
    }

    public DeviceEntity removeDevice(DeviceEntity device, int count) {
        if (count > devices.get(device.getId()).getCount()) {
            throw new WrongAmountException("The amount of devices in the cart is less than you want to remove!");
        } else if (count == devices.get(device.getId()).getCount()) {
            devices.remove(device.getId());
        } else if (count < devices.get(device.getId()).getCount()) {
            devices.get(device.getId()).setCount(devices.get(device.getId()).getCount() - count);
        }
        deviceDB.getDevice(device.getId()).setCount(deviceDB.getDevice(device.getId()).getCount() + count);
        totalPrice -= device.getPrice() * count;
        LOGGER.log(Level.INFO, "{0} removed, count: {1} price: {2}", new Object[]{device.toString(), count, count * device.getPrice()});
        return devices.get(device.getId());
    }

    @Remove
    public void removeAllDevices() {
        List<DeviceEntity> deviceList = getAllDevices();
        for (DeviceEntity device : deviceList) {
            removeDevice(device, device.getCount());
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<DeviceEntity> getAllDevices() {
        return new ArrayList(this.devices.values());
    }

    @Remove
    public List<DeviceEntity> buyCart() {
        List<DeviceEntity> deviceList = getAllDevices();
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
        return deviceList;
    }
}

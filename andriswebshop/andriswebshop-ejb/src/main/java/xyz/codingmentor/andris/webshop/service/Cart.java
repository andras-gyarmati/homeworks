package xyz.codingmentor.andris.webshop.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;
import xyz.codingmentor.andris.webshop.bean.DeviceEntity;
import xyz.codingmentor.andris.webshop.database.DeviceDB;
import xyz.codingmentor.andris.webshop.exceptions.WrongAmountException;

/**
 *
 * @author brianelete
 */
@Stateful
public class Cart implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(Cart.class.getName());
    private final Map<String, DeviceEntity> devices = new HashMap<>();
    private DeviceDB deviceDB;
    private int totalPrice;

    public Cart() {
        //empty
    }

    @Inject
    public Cart(DeviceDB deviceDB) {
        this.deviceDB = deviceDB;
    }

    public List<DeviceEntity> addDevice(String id, int count) {
        if (count <= deviceDB.getDevice(id).getCount()) {
            DeviceEntity deviceToAdd = new DeviceEntity(null, deviceDB.getDevice(id).getManufacturer(), deviceDB.getDevice(id).getType(), deviceDB.getDevice(id).getPrice(), deviceDB.getDevice(id).getColor(), count);
            deviceToAdd.setId(id); 
            deviceDB.getDevice(id).setCount(deviceDB.getDevice(id).getCount() - count);
            addDeviceOrIncreaseCount(deviceToAdd);
            totalPrice += deviceToAdd.getPrice() * count;
            LOGGER.log(Level.INFO, "{0} added, count: {1} price: {2}", new Object[]{deviceToAdd.toString(), deviceToAdd.getCount(), deviceToAdd.getCount() * deviceToAdd.getPrice()});
        } else {
            throw new WrongAmountException("The amount of devices in the database is less than you want to add!");
        }
        return getCart();
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
        List<DeviceEntity> deviceList = getCart();
        for (DeviceEntity device : deviceList) {
            removeDevice(device, device.getCount());
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<DeviceEntity> getCart() {
        return new ArrayList<>(devices.values());
    }

    public List<DeviceEntity> buyCart() {
        List<DeviceEntity> deviceList = getCart();
        if (deviceList.isEmpty()) {
            LOGGER.log(Level.INFO, "Your cart is empty!");
        } else {
            for (DeviceEntity device : deviceList) {
                if (0 != device.getCount()) {
                    LOGGER.log(Level.INFO, "Purchased: {0} count: {1} price: {2}", new Object[]{device.toString(), device.getCount(), device.getCount() * device.getPrice()});
                }
            }
            devices.clear();
        }
        return deviceList;
    }

    private void addDeviceOrIncreaseCount(DeviceEntity addedDevice) {
        if (devices.containsKey(addedDevice.getId())) {
            devices.get(addedDevice.getId()).setCount(devices.get(addedDevice.getId()).getCount() + addedDevice.getCount());
        } else {
            devices.put(addedDevice.getId(), addedDevice);
        }
    }
}

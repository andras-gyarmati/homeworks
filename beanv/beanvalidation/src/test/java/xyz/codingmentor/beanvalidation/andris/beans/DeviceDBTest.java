package xyz.codingmentor.beanvalidation.andris.beans;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author brianelete
 */
public class DeviceDBTest {

    private DeviceDB deviceDB;

    public DeviceDBTest() {
        // empty
    }

    @Test
    public void addDevice() {
        deviceDB = new DeviceDB();
        Assert.assertEquals(0, deviceDB.getAllDevice().size());
        deviceDB.addDevice(new DeviceEntity(null, Manufacturer.ONEPLUS, "Two", 130000, Color.BLACK, 0));
        Assert.assertEquals(1, deviceDB.getAllDevice().size());
    }

    @Test
    public void editDevice() {
        deviceDB = new DeviceDB();
        DeviceEntity device = new DeviceEntity(null, Manufacturer.ONEPLUS, "Two", 130000, Color.BLACK, 0);
        deviceDB.addDevice(device);
        Assert.assertEquals(0, deviceDB.getDevice(device.getId()).getCount());
        device.setCount(2);
        deviceDB.editDevice(device);
        Assert.assertEquals(2, deviceDB.getDevice(device.getId()).getCount());
    }

    @Test
    public void deleteDevice() {
        deviceDB = new DeviceDB();
        DeviceEntity device = new DeviceEntity(null, Manufacturer.ONEPLUS, "Two", 130000, Color.BLACK, 0);
        deviceDB.addDevice(device);
        Assert.assertEquals(1, deviceDB.getAllDevice().size());
        deviceDB.deleteDevice(device);
        Assert.assertEquals(0, deviceDB.getAllDevice().size());
    }

    @Test(expected = DeviceNotFoundException.class)
    public void deleteDeviceFromEmptyMap() {
        deviceDB = new DeviceDB();
        DeviceEntity device = new DeviceEntity(null, Manufacturer.ONEPLUS, "Two", 130000, Color.BLACK, 0);
        deviceDB.deleteDevice(device);
        Assert.assertEquals(0, deviceDB.getAllDevice().size());
    }

    @Test
    public void getAllDevices() {
        deviceDB = new DeviceDB();
        DeviceEntity device0 = new DeviceEntity(null, Manufacturer.ONEPLUS, "Two", 130000, Color.BLACK, 0);
        DeviceEntity device1 = new DeviceEntity(null, Manufacturer.APPLE, "Six", 240000, Color.WHITE, 0);
        deviceDB.addDevice(device0);
        deviceDB.addDevice(device1);
        List<DeviceEntity> allDevice = deviceDB.getAllDevice();
        Assert.assertEquals(2, allDevice.size());
    }

}

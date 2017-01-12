package xyz.codingmentor.beanvalidation.andris.beans;

import xyz.codingmentor.beanvalidation.andris.bean.DeviceEntity;
import xyz.codingmentor.beanvalidation.andris.enums.Manufacturer;
import xyz.codingmentor.beanvalidation.andris.enums.Color;
import xyz.codingmentor.beanvalidation.andris.database.DeviceDBSingleton;
import xyz.codingmentor.beanvalidation.andris.exception.DeviceNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author brianelete
 */
public class DeviceDBTest {

    private static DeviceDBSingleton deviceDB;

    public DeviceDBTest() {
        // empty
    }

    @BeforeClass
    public static void init() {
        deviceDB = DeviceDBSingleton.INSTANCE;
    }

    @Before
    public void initDB() {
        List<DeviceEntity> devices = deviceDB.getAllDevice();
        for (DeviceEntity device : devices) {
            deviceDB.deleteDevice(device);
        }
    }

    @Test
    public void addDevice() {
        Assert.assertEquals(0, deviceDB.getAllDevice().size());
        deviceDB.addDevice(new DeviceEntity(null, Manufacturer.ONEPLUS, "Two", 130000, Color.BLACK, 0));
        Assert.assertEquals(1, deviceDB.getAllDevice().size());
    }

    @Test
    public void editDevice() {
        DeviceEntity device = new DeviceEntity(null, Manufacturer.ONEPLUS, "Two", 130000, Color.BLACK, 0);
        deviceDB.addDevice(device);
        Assert.assertEquals(0, deviceDB.getDevice(device.getId()).getCount());
        device.setCount(2);
        deviceDB.editDevice(device);
        Assert.assertEquals(2, deviceDB.getDevice(device.getId()).getCount());
    }

    @Test
    public void deleteDevice() {
        DeviceEntity device = new DeviceEntity(null, Manufacturer.ONEPLUS, "Two", 130000, Color.BLACK, 0);
        deviceDB.addDevice(device);
        Assert.assertEquals(1, deviceDB.getAllDevice().size());
        deviceDB.deleteDevice(device);
        Assert.assertEquals(0, deviceDB.getAllDevice().size());
    }

    @Test(expected = DeviceNotFoundException.class)
    public void deleteDeviceFromEmptyMap() {
        DeviceEntity device = new DeviceEntity(null, Manufacturer.ONEPLUS, "Two", 130000, Color.BLACK, 0);
        deviceDB.deleteDevice(device);
        Assert.assertEquals(0, deviceDB.getAllDevice().size());
    }

    @Test
    public void getAllDevices() {
        DeviceEntity device0 = new DeviceEntity(null, Manufacturer.ONEPLUS, "Two", 130000, Color.BLACK, 0);
        DeviceEntity device1 = new DeviceEntity(null, Manufacturer.APPLE, "Six", 240000, Color.WHITE, 0);
        deviceDB.addDevice(device0);
        deviceDB.addDevice(device1);
        List<DeviceEntity> allDevice = deviceDB.getAllDevice();
        Assert.assertEquals(2, allDevice.size());
    }

}

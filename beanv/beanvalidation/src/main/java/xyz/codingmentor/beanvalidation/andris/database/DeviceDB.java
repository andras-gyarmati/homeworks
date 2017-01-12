package xyz.codingmentor.beanvalidation.andris.database;

import java.util.List;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.beanvalidation.andris.bean.DeviceEntity;
import xyz.codingmentor.beanvalidation.andris.interceptor.ValidatorInterceptor;

/**
 *
 * @author brianelete
 */
@Interceptors(ValidatorInterceptor.class)
public class DeviceDB {

    private DeviceDBSingleton deviceDB = DeviceDBSingleton.INSTANCE;

    @ExcludeClassInterceptors
    public void addDevice(DeviceEntity device) {
        deviceDB.addDevice(device);
    }

    public DeviceEntity editDevice(DeviceEntity device) {
        DeviceEntity editedDevice = deviceDB.editDevice(device);
        return editedDevice;
    }

    public DeviceEntity getDevice(String id) {
        return deviceDB.getDevice(id);
    }

    public DeviceEntity deleteDevice(DeviceEntity device) {
        DeviceEntity deletedDevice = deviceDB.deleteDevice(device);
        return deletedDevice;
    }

    public List<DeviceEntity> getAllDevice() {
        return deviceDB.getAllDevice();
    }

}

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

    private final DeviceDBSingleton deviceDBSingleton;

    public DeviceDB() {
        this.deviceDBSingleton = DeviceDBSingleton.INSTANCE;
    }

    @ExcludeClassInterceptors
    public void addDevice(DeviceEntity device) {
        deviceDBSingleton.addDevice(device);
    }

    public DeviceEntity editDevice(DeviceEntity device) {
        return deviceDBSingleton.editDevice(device);

    }

    public DeviceEntity getDevice(String id) {
        return deviceDBSingleton.getDevice(id);
    }

    public DeviceEntity deleteDevice(DeviceEntity device) {
        return deviceDBSingleton.deleteDevice(device);

    }

    public List<DeviceEntity> getAllDevice() {
        return deviceDBSingleton.getAllDevice();
    }

}

package xyz.codingmentor.beanvalidation.andris.beans;

/**
 *
 * @author brianelete
 */
public class DeviceNotFoundException extends RuntimeException {

    public DeviceNotFoundException() {
        //empty
    }

    public DeviceNotFoundException(String message) {
        super(message);
    }

    public DeviceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceNotFoundException(Throwable cause) {
        super(cause);
    }

    public DeviceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

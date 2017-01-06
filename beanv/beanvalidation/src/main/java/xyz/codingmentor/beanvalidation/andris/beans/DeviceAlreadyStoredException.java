package xyz.codingmentor.beanvalidation.andris.beans;

/**
 *
 * @author brianelete
 */
public class DeviceAlreadyStoredException extends RuntimeException {

    public DeviceAlreadyStoredException() {
        //empty
    }

    public DeviceAlreadyStoredException(String message) {
        super(message);
    }

    public DeviceAlreadyStoredException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceAlreadyStoredException(Throwable cause) {
        super(cause);
    }

    public DeviceAlreadyStoredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

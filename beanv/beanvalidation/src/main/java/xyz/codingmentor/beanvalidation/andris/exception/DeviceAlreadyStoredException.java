package xyz.codingmentor.beanvalidation.andris.exception;

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
}

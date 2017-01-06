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
}

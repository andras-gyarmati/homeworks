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
}

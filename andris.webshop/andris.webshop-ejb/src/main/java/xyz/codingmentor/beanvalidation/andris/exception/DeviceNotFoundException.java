package xyz.codingmentor.beanvalidation.andris.exception;

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

package xyz.codingmentor.andris.webshop.exception;

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

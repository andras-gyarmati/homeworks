package xyz.codingmentor.andris.webshop.exceptions;

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

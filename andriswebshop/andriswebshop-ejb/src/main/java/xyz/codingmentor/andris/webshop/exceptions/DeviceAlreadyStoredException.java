package xyz.codingmentor.andris.webshop.exceptions;

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

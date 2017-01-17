package xyz.codingmentor.andris.webshop.exception;

/**
 *
 * @author brianelete
 */
public class NotLoggedInException extends RuntimeException {

    public NotLoggedInException() {
        //empty
    }

    public NotLoggedInException(String message) {
        super(message);
    }
    
}

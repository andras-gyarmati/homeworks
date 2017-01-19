package xyz.codingmentor.andris.webshop.exceptions;

/**
 *
 * @author brianelete
 */
public class UsernameTakenException extends RuntimeException {

    public UsernameTakenException() {
        //empty
    }

    public UsernameTakenException(String message) {
        super(message);
    }    
}

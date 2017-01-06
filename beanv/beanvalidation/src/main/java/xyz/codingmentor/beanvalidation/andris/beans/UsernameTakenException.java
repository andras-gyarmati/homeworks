package xyz.codingmentor.beanvalidation.andris.beans;

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

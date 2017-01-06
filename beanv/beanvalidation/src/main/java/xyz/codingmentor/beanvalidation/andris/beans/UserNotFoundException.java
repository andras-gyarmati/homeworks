package xyz.codingmentor.beanvalidation.andris.beans;

/**
 *
 * @author brianelete
 */
public class UserNotFoundException extends  RuntimeException {

    public UserNotFoundException() {
        //empty
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}

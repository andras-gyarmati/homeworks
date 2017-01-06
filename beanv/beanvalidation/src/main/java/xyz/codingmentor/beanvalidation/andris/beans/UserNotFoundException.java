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

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

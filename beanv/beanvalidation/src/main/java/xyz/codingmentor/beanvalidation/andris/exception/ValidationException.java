package xyz.codingmentor.beanvalidation.andris.exception;

/**
 *
 * @author brianelete
 */
public class ValidationException extends RuntimeException{
    
    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException() {
        super();
    }
}

package xyz.codingmentor.andris.webshop.exceptions;

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

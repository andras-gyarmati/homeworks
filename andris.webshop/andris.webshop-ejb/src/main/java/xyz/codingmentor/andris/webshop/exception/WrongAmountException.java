package xyz.codingmentor.andris.webshop.exception;

/**
 *
 * @author brianelete
 */
public class WrongAmountException extends RuntimeException {

    public WrongAmountException(String message) {
        super(message);
    }
}

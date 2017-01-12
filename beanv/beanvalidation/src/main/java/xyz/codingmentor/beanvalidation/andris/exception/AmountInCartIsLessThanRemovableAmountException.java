package xyz.codingmentor.beanvalidation.andris.exception;

/**
 *
 * @author brianelete
 */
public class AmountInCartIsLessThanRemovableAmountException extends RuntimeException {

    public AmountInCartIsLessThanRemovableAmountException(String message) {
        super(message);
    }
}

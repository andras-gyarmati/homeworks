package xyz.codingmentor.jpaweb.ex;

/**
 *
 * @author brianelete
 */
public class EmptyParametersException extends RuntimeException {

    public EmptyParametersException() {
        //empty
    }

    public EmptyParametersException(String message) {
        super(message);
    }

    public EmptyParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyParametersException(Throwable cause) {
        super(cause);
    }

    public EmptyParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

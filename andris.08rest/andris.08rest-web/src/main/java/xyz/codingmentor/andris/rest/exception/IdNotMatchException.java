package xyz.codingmentor.andris.rest.exception;

/**
 *
 * @author brianelete
 */
public class IdNotMatchException extends RuntimeException {

    public IdNotMatchException(String msg) {
        super(msg);
    }

    public IdNotMatchException() {
        super();
    }

}

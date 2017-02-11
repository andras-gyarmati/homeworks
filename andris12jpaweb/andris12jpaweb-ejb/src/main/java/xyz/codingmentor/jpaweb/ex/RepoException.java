package xyz.codingmentor.jpaweb.ex;

/**
 *
 * @author brianelete
 */
public class RepoException extends Exception {

    public RepoException() {
        //empty
    }

    public RepoException(String message) {
        super(message);
    }

    public RepoException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepoException(Throwable cause) {
        super(cause);
    }

    public RepoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

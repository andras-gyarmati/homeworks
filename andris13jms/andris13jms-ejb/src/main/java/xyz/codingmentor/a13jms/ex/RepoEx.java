package xyz.codingmentor.a13jms.ex;

/**
 *
 * @author brianelete
 */
public class RepoEx extends Exception {

    public RepoEx() {
        //empty
    }

    public RepoEx(String message) {
        super(message);
    }

    public RepoEx(String message, Throwable cause) {
        super(message, cause);
    }

    public RepoEx(Throwable cause) {
        super(cause);
    }

    public RepoEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

package xyz.codingmentor.andris.webshop.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author brianelete
 */
@ApplicationException
public class AuthenticationFailureException extends Exception  {

    public AuthenticationFailureException() {
        //empty
    }

    public AuthenticationFailureException(String message) {
        super(message);
    }

}

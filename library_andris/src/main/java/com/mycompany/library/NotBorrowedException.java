/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

/**
 *
 * @author brianelete
 */
public class NotBorrowedException extends RuntimeException {

    public NotBorrowedException() {
        //empty
    }

    public NotBorrowedException(String message) {
        super(message);
    }

    public NotBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotBorrowedException(Throwable cause) {
        super(cause);
    }

    public NotBorrowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

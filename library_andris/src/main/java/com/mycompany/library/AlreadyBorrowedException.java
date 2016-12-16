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
public class AlreadyBorrowedException extends RuntimeException {

    public AlreadyBorrowedException() {
        //empty
    }

    public AlreadyBorrowedException(String message) {
        super(message);
    }

    public AlreadyBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyBorrowedException(Throwable cause) {
        super(cause);
    }

    public AlreadyBorrowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

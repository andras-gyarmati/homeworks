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
public abstract class PrintedMedia implements IBorrowable {

    private final String id;
    private final String title;
    private Boolean borrowed;

    public PrintedMedia(String id, String title) {
        this.id = id;
        this.title = title;
        borrowed = false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Boolean getBorrowed() {
        return borrowed;
    }

    @Override
    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    
}

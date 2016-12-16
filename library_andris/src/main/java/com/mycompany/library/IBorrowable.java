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
public interface IBorrowable {

    public String getId();

    public String getTitle();

    public Boolean getBorrowed();

    public void setBorrowed(Boolean borrowed);
}

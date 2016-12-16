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
public class Book extends PrintedMedia {

   private final String author;

    public Book(String isbn, String title, String author) {
        super(isbn, title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

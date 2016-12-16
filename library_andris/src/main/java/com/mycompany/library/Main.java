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
public class Main {

    private Main() {
    }

    public static void main(String[] args) {
        Library library = Library.getInstance();
        String asimov = "Isaac Asimov";
        String id = "9780606275743";
        library.newBook("9780606275743", "Prelude to Foundation", asimov);
        library.newBook("9780307970633", "Forward the Foundation", asimov);
        library.newBook("9780553900347", "Foundation", asimov);
        library.newBook("9788804403012", "Foundation and Empire", asimov);
        library.newBook("9783453164178", "Second Foundation", asimov);
        library.newBook("9780918372109", "Foundation's Edge", asimov);
        library.newBook("9788576571377", "Foundation and Earth", asimov);
        library.newMagazine("0040-781X", "Time");
        library.newMagazine("1753-3147", "SciFiNow");
        library.newMember("John Doe", "812653872");
        library.newMember("Jane Doe", "891263216");
        library.borrowItem("812653872", id);
        library.borrowItem("812653873", id);
    }
}

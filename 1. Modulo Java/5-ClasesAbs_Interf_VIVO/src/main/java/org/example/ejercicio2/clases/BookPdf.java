package org.example.ejercicio2.clases;

import org.example.ejercicio2.interfaces.IPrintable;

public class BookPdf extends Document{
    int pages;
    String author;
    String title;
    String gender;

    public BookPdf(int pages, String author, String title, String gender) {
        this.pages = pages;
        this.author = author;
        this.title = title;
        this.gender = gender;
    }

    @Override
    public void print() {
        super.printFileType();
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Gender: " + this.gender);
        System.out.println("Pages: " + this.pages);
    }
}

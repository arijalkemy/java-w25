package org.example.exercise2.impl;

import org.example.exercise2.Document;

public class PDFBook extends Document {
    private String authorName;
    private int pages;
    private String title;

    public PDFBook(String authorName, int pages, String title) {
        this.authorName = authorName;
        this.pages = pages;
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("LIBRO PDF:");
        System.out.println("PDFBook{" +
                "authorName='" + authorName + '\'' +
                ", pages=" + pages +
                ", title='" + title + '\'' +
                '}');
    }

}

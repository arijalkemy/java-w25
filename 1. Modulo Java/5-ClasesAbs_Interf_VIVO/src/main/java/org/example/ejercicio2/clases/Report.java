package org.example.ejercicio2.clases;

public class Report extends Document{
    int textSize;
    int pages;
    String author;
    String reviewer;

    public Report(int textSize, int pages, String author, String reviewer) {
        this.textSize = textSize;
        this.pages = pages;
        this.author = author;
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Report{" +
                "textSize=" + textSize +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", reviewer='" + reviewer + '\'' +
                '}';
    }

    @Override
    public void print() {
        super.printFileType();
        System.out.println("Text Size: " + this.textSize);
        System.out.println("Pages: " + this.pages);
        System.out.println("Author: " + this.author);
        System.out.println("Reviewer: " + this.reviewer);
    }
}

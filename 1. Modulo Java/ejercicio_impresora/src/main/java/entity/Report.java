package entity;

import service.IPrintable;

public class Report implements IPrintable {
    private String text;
    private int pages;
    private String author;
    private String reviewer;

    public Report(String text, int pages, String author, String reviewer) {
        this.text = text;
        this.pages = pages;
        this.author = author;
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Report{" +
                "text='" + text + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", reviewer='" + reviewer + '\'' +
                '}';
    }
}
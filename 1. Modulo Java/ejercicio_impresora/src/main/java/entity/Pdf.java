package entity;

import service.IPrintable;

public class Pdf implements IPrintable {
    private Book book;

    public Pdf(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Pdf{" +
                "book=" + book +
                '}';
    }
}

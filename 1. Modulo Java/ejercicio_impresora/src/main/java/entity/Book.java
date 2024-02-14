package entity;

public class Book {
    private int pages;
    private String author;
    private String title;
    private String genre;

    public Book(int pages, String author, String title, String genre) {
        this.pages = pages;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pages=" + pages +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}

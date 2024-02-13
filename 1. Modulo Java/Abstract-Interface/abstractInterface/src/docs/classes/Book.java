package docs.classes;

public class Book extends Document {

    private Integer pagesCount;
    private String authorName;
    private String title;
    private String gender;

    public Book(Integer pagesCount, String authorName, String title, String gender) {
        this.pagesCount = pagesCount;
        this.authorName = authorName;
        this.title = title;
        this.gender = gender;
        type = "Libro PDF";
    }
}

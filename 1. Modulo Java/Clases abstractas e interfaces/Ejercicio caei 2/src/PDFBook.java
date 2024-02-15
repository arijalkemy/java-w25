public class PDFBook implements Printable{
    private int amountPages;
    private String authorName;
    private String title;
    private String genre;

    public PDFBook(int amountPages, String authorName, String title, String genre) {
        this.amountPages = amountPages;
        this.authorName = authorName;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public void print() {
        System.out.println("PDFBook{" +
                "amountPages=" + amountPages +
                ", authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}'
        );
    }
}

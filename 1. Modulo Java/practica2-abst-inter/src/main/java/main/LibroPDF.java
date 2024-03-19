package main;

public class LibroPDF implements Imprimible{

    private int numberOfPages;
    private String authorsName;
    private String title;
    private String type;

    public LibroPDF(int numberOfPages, String authorsName, String title, String type) {
        this.numberOfPages = numberOfPages;
        this.authorsName = authorsName;
        this.title = title;
        this.type = type;
    }

    @Override
    public void imprimir() {
        System.out.println("LibroPDF{" +
                "numberOfPages=" + numberOfPages +
                ", authorsName='" + authorsName + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}');
    }

}

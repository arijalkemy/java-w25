package main;

public class Informe implements Imprimible{

    private String text;
    private int numberOfPages;
    private String authorsName;
    private String reviewer;

    public Informe(String text, int numberOfPages, String authorsName, String reviewer) {
        this.text = text;
        this.numberOfPages = numberOfPages;
        this.authorsName = authorsName;
        this.reviewer = reviewer;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe{" +
                "text='" + text + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", authorsName='" + authorsName + '\'' +
                ", reviewer='" + reviewer + '\'' +
                '}');
    }
}

package org.bootcamp.ejercicio2.model;

public class Report extends Document {
    private String text;
    private int quantityPages;
    private String autor;
    private String reviewer;

    public Report(String typeDocument, String text, int quantityPages, String autor, String reviewer) {
        super(typeDocument);
        this.text = text;
        this.quantityPages = quantityPages;
        this.autor = autor;
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Report{" +
                "text='" + text + '\'' +
                ", quantityPages=" + quantityPages +
                ", autor='" + autor + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", typeDocument='" + typeDocument + '\'' +
                '}';
    }
}

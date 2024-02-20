package org.bootcamp.ejercicio2.model;

public class BookPdf extends Document{
    private String autorName;
    private String title;
    private String gender;
    private int quantityPages;

    public BookPdf(String typeDocument, String autorName, String title, String gender, int quantityPages) {
        super(typeDocument);
        this.autorName = autorName;
        this.title = title;
        this.gender = gender;
        this.quantityPages = quantityPages;
    }

    @Override
    public String toString() {
        return "BookPdf{" +
                "autorName='" + autorName + '\'' +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", quantityPages=" + quantityPages +
                ", typeDocument='" + typeDocument + '\'' +
                '}';
    }
}

package models;

public class Informe {
    private String texto;

    private String nombreAutor;

    private String nombreRevisor;

    public Informe(String texto, String nombreAutor, String nombreRevisor) {
        this.texto = texto;
        this.nombreAutor = nombreAutor;
        this.nombreRevisor = nombreRevisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNombreRevisor() {
        return nombreRevisor;
    }

    public void setNombreRevisor(String nombreRevisor) {
        this.nombreRevisor = nombreRevisor;
    }
}

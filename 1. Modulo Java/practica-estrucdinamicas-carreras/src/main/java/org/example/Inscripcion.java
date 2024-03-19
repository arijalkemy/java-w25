package org.example;

public class Inscripcion {

    private int idInscripcion;
    private Category categoria;
    private Competitor competitor;
    private double totalPago;

    public Inscripcion(int idInscripcion, Category categoria, Competitor competitor, double totalPago) {
        this.idInscripcion = idInscripcion;
        this.categoria = categoria;
        this.competitor = competitor;
        this.totalPago = totalPago;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "idInscripcion=" + idInscripcion +
                ", categoria=" + categoria +
                ", competitor=" + competitor +
                ", totalPago=" + totalPago +
                '}';
    }
}

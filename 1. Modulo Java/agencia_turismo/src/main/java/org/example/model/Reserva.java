package org.example.model;

public class Reserva {
    private int idReserva;
    private String tipo;
    private double costo;

    public Reserva(int idReserva, String tipo, double costo) {
        this.idReserva = idReserva;
        this.tipo = tipo;
        this.costo = costo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", tipo='" + tipo + '\'' +
                ", costo=" + costo +
                '}';
    }
}

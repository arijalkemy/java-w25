package org.example.model;

public class Reserva {
    private double precio;
    private Paquete paqueteReservado;

    public Reserva() {
    }

    public Reserva( Paquete paqueteReservado, double precio) {
        this.precio = precio;
        this.paqueteReservado = paqueteReservado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Paquete getPaqueteReservado() {
        return paqueteReservado;
    }

    public void setPaqueteReservado(Paquete paqueteReservado) {
        this.paqueteReservado = paqueteReservado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "precio=" + precio +
                ", paqueteReservado=" + paqueteReservado +
                '}';
    }


}

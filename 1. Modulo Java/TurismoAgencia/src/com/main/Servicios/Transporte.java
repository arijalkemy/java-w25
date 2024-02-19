package com.main.Servicios;

public class Transporte extends Reservas{

    public Transporte(double precio, double cantidad) {
        super(precio, cantidad);
    }

    @Override
    public void realizarReserva() {
        System.out.println("Reserva Transporte -> "+"Precio: "+this.precio+" Cantidad: "+this.cantidad);
    }
    @Override
    public String toString() {
        return "Transporte -> " + this.total;
    }
}

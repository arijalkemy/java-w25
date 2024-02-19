package com.main.Servicios;

import com.main.Servicios.Reservas;

public class Comida extends Reservas {

    public Comida(double precio, double cantidad) {
        super(precio, cantidad);
    }

    @Override
    public void realizarReserva() {
        System.out.println("Reserva Comida -> "+"Precio: "+this.precio+" Cantidad: "+this.cantidad);
    }

    @Override
    public String toString() {
        return "Comida -> " + this.total;
    }
}

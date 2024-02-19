package com.main.Servicios;

import com.main.Servicios.Reservas;

public class Hotel extends Reservas {


    public Hotel(double precio, double cantidad) {
        super(precio, cantidad);
    }

    @Override
    public void realizarReserva() {
        System.out.println("Reserva Hotel -> "+"Precio: "+this.precio+" Cantidad: "+this.cantidad);
    }

    @Override
    public String toString() {
        return "Hotel -> " + this.total;
    }
}

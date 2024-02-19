package com.main.Servicios;

public class BoletosViaje extends Reservas{

    public BoletosViaje(double precio, double cantidad) {
        super(precio, cantidad);
    }

    @Override
    public void realizarReserva() {
        System.out.println("Reserva Boletos Viaje -> "+"Precio: "+this.precio+" Cantidad: "+this.cantidad);
    }

    @Override
    public String toString() {
        return "Boletos Viaje -> " + this.total;
    }

}

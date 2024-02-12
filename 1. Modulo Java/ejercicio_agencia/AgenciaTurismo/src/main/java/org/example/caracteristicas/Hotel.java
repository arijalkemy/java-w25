package org.example.caracteristicas;

import org.example.model.IReserva;

public class Hotel implements IReserva
{
    protected IReserva reserva;

    public Hotel(IReserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public Double getPrecio() {
        return reserva.getPrecio() + 200;
    }

    @Override
    public String getCaracteristicas() {
        return reserva.getCaracteristicas() + " + Hotel";
    }
}

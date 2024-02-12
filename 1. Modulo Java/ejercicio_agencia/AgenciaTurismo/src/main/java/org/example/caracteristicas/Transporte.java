package org.example.caracteristicas;

import org.example.model.IReserva;

public class Transporte implements IReserva {

    protected IReserva reserva;

    public Transporte(IReserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public Double getPrecio() {
        return reserva.getPrecio() + 200;
    }

    @Override
    public String getCaracteristicas() {
        return reserva.getCaracteristicas() + " + Transporte";
    }
}

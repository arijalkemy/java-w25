package org.example.caracteristicas;

import org.example.model.IReserva;

public class Comida implements IReserva {
    protected IReserva reserva;

    public Comida(IReserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public Double getPrecio() {
        return reserva.getPrecio() + 100;
    }

    @Override
    public String getCaracteristicas() {
        return reserva.getCaracteristicas() + " + Comida";
    }
}

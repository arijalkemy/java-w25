package org.example.caracteristicas;

import org.example.model.IReserva;

public class BoletoViaje implements IReserva {
    protected IReserva reserva;

    public BoletoViaje(IReserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public Double getPrecio() {
        return reserva.getPrecio() + 300;
    }

    @Override
    public String getCaracteristicas() {
        return reserva.getCaracteristicas() + " + Boleto de Viaje";
    }

}

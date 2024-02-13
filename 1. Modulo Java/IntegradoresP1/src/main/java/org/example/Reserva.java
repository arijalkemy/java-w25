package org.example;

public class Reserva {

    private double total;
    private TipoReserva tipoReserva; // Hotel, comida, transporte y boleto

    public Reserva(double total, TipoReserva tipoReserva) {
        this.total = total;
        this.tipoReserva = tipoReserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva (TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }
}


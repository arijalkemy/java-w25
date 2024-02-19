package com.main.Clases;

public class RepositorioReservas {
    private LocalizadorReservas lcReserva;

    public RepositorioReservas(LocalizadorReservas lcReserva) {
        this.lcReserva = lcReserva;
    }

    public LocalizadorReservas getLcReserva() {
        return lcReserva;
    }

    public void setLcReserva(LocalizadorReservas lcReserva) {
        this.lcReserva = lcReserva;
    }

    @Override
    public String toString() {
        return "--REPOSITORIO--"+lcReserva;
    }
}

package org.example;

import java.util.List;

public class Localizador {

    private Cliente cliente;
    private double total;
    private List<Reserva> listaDeReservas;

    public Localizador(Cliente cliente, List<Reserva> listaDeReservas) {
        this.cliente = cliente;
        this.listaDeReservas = listaDeReservas;
    }

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
    }

}

package org.example;

import org.example.model.Cliente;
import org.example.model.IReserva;
import org.example.model.ReservaBase;

import java.util.ArrayList;

public class Localizador {
    Cliente cliente;
    ArrayList<IReserva> reservas = new ArrayList<IReserva>();

    public Localizador(Cliente cliente, ArrayList<IReserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public void guardarReserva(IReserva reserva){
        //Repositorio repositorio = new Repositorio();
        //var localizadores = repositorio.getLocalizadoresByDni(cliente.getDni());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<IReserva> getReservas() {
        return reservas;
    }
}

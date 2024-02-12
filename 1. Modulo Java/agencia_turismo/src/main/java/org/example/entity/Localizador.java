package org.example.entity;

import java.util.ArrayList;
import java.util.List;


public class Localizador {
    private int id;
    private Cliente cliente;
    private final List<Reservas> reservasList;

    public Localizador(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.reservasList = new ArrayList<>();
    }

    public void addReserva(Reservas reserva){
        reservasList.add(reserva);
    }
    public double getTotalPrice(){
        return reservasList.stream().mapToDouble(Reservas::getPrecio).sum();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}

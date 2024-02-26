package org.example;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private List<Reserva> reservaList;
    private Cliente cliente;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservaList =new ArrayList<>();
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void addReserva(Reserva re){
        this.reservaList.add(re);
    }

}

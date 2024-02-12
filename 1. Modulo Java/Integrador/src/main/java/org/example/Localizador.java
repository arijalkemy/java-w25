package org.example;

import java.util.LinkedList;
import java.util.List;

public class Localizador {

    private long id;
    private Cliente client;
    private double total;
    private LinkedList<Reserva> reservas;
    private Repositorio repoRef;

    public Localizador(long id, Cliente client, LinkedList<Reserva> reservas, Repositorio repoRef) {
        this.id = id;
        this.client = client;
        this.reservas = reservas;
        this.repoRef = repoRef;
    }

    public Localizador(long id, Cliente client,Repositorio repoRef) {
        this.id = id;
        this.client = client;
        this.reservas = new LinkedList<Reserva>();
        this.repoRef = repoRef;
    }

    public Localizador(long id, Cliente client) {
        this.id = id;
        this.client = client;
        this.reservas = new LinkedList<Reserva>();
    }

    public double calcularTotal() {


        double precio = reservas.stream()
                .flatMap(reserva -> reserva.getProductos().stream())
                .mapToDouble(Producto::getPrecio)
                .sum();

        if ((this.getLocalizadores()!= null )&&  (this.getLocalizadores().size() >= 2)) {
            return precio * 0.95;
        }



        return precio;


    }


    public List<Localizador> getLocalizadores() {
        return repoRef.getLocalizadoresByCliente(this.client);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    @Override
    public String toString() {
        return "Localizador";
    }
}

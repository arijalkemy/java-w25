package main;

import java.util.List;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> paquete;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> paquete, double total) {
        this.cliente = cliente;
        this.paquete = paquete;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", paquete=" + paquete +
                ", total=" + total +
                '}';
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getPaquete() {
        return paquete;
    }

    public void setPaquete(List<Reserva> paquete) {
        this.paquete = paquete;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

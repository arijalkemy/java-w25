package supermercado.model;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura() {
    }

    public Factura(Cliente cliente, List<Item> items, double total) {
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CLIENTE: " + this.cliente.toString()
                + "\nITEMS:" + this.items.toString()
                + "\nTOTAL: " + this.total;
    }

    public double calcularTotal() {
        double total = 0.0;

        for (Item i : items) {
            total += i.getCantComprada() * i.getPrecioUnitario();
        }

        return total;
    }
}

package org.clase06_02_24.ejercicio_supermercado;

import java.util.List;

public class Factura {
    Cliente cliente;
    List<Item> items;

    Double totalCompra;

    public Factura(Cliente cliente, List<Item> items, Double totalCompra) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
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

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }
}

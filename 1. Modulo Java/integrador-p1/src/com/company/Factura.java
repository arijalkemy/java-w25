package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items = new ArrayList<Item>();
    private BigDecimal totalVenta = new BigDecimal(0);

    public Factura(Cliente cliente, List<Item> items, BigDecimal totalVenta) {
        this.cliente = cliente;
        this.items = items;
        this.totalVenta = totalVenta;
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

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }
}

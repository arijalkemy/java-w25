package com.company.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private BigDecimal totalVenta = new BigDecimal("0.0");

    public Factura(Cliente cliente, List<Item> items) {
        calcularTotal(items);
        this.cliente = cliente;
        this.items = items;

    }

    public void calcularTotal(List<Item> items){
        for (Item item: items) {
            this.totalVenta = this.totalVenta.add(
                    item.getCostoUnitario()
                            .multiply(
                                    BigDecimal.valueOf(
                                            item.getCantidadComprada())));
        }
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

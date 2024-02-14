package model;

import model.Item;

import java.util.List;

public class Factura {
    private long codigo;
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura() {
    }

    public Factura(long codigo, Cliente cliente, List<Item> items) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal();
    }

    private double calcularTotal(){
        double suma = 0;
        for(Item item : items){
            suma += item.getCostoUnitario() * item.getCantidadComprada();
        }
        return suma;
    }

    @Override
    public String toString() {
        return "model.Factura{" +
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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
}

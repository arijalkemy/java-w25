package main.Model;


import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> listaCompra;
    private double costoTotal;

    public Factura(Cliente cliente, List<Item> listaCompra, double costoTotal) {
        this.cliente = cliente;
        this.listaCompra = listaCompra;
        this.costoTotal = costoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<Item> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}

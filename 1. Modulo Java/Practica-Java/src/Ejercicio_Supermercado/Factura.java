package Ejercicio_Supermercado;

import java.util.List;

public class Factura {
    private Cliente_Super cliente;
    private List<Item> listaItems;
    private Double totalCompra;

    public Factura(Cliente_Super cliente, List<Item> listaItems, Double totalCompra) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = totalCompra;
    }

    public Cliente_Super getCliente() {
        return cliente;
    }

    public void setCliente(Cliente_Super cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }
}

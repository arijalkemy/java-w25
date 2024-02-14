package org.example.model;

import java.util.List;

public class Factura {

    private Long codigo;
    private Cliente cli;
    private List<Item> listaItem;
    private double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cli, List<Item> listaItem, double total) {
        this.codigo = codigo;
        this.cli = cli;
        this.listaItem = listaItem;
        this.total = total;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Item> getListaItem() {
        return listaItem;
    }

    public void setListaItem(List<Item> listaItem) {
        this.listaItem = listaItem;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

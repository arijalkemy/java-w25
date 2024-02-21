package Supermercado.Models;

import java.util.List;

public class Factura {
    private int id = 0;
    private Cliente cliente;
    private List<Item> items;

    public Factura(Cliente cliente, List<Item> items) {
        this.id += 1;
        this.cliente = cliente;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    
}

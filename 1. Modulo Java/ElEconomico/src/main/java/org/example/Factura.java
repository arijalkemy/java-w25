package org.example;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    List<Item> items = new ArrayList<>();

    // Constructor
    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public Double totalDeCompra (){
      return 0.0;
    };

    //Getter y Setters

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
}

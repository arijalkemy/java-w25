package bootcamp.Model;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double precioTotal;

    public Factura(Cliente cliente, List<Item> items, double precioTotal) {
        this.cliente = cliente;
        this.items = items;
        this.precioTotal = precioTotal;
    }
    public Factura(Cliente cliente, List<Item> items){
        this.cliente = cliente;
        this.items = items;
        this.precioTotal = items.stream().mapToDouble(Item::getPrecioUnitario).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Factura() {
    }
}

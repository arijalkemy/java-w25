package bootcamp.Model;

import bootcamp.Model.Producto;

public class Item {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public Item(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}

package org.example;

public class Distribuidora {

    private Producto[] productos;

    public Distribuidora() {
        productos = new Producto[]{
                new Perecedero("Leche", 1.20, 1),
                new NoPerecedero("Harina", 0.80, "Grano"),
                new Perecedero("Yogurt", 2.00, 2),
                new NoPerecedero("Arroz", 0.70, "Grano"),
                new Perecedero("Jamon", 3.50, 1)
        };
    }

    public double calcularPrecioTotalPorCantidad(int cantidad) {
        double total = 0.0;
        for (Producto p : productos) {
            total += p.calcular(cantidad);
        }
        return total;
    }
}

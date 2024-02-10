package org.example;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        double precioCarrito = 0;


        productos.add(new Perecedero("Leche", 100, 1));
        productos.add(new NoPerecedero("Coca-Cola", 200, "Bebida"));
        productos.add(new Perecedero("Yogurt", 300, 2));
        productos.add(new NoPerecedero("Pan", 400, "Panadería"));
        productos.add(new Perecedero("Queso", 500, 3));
        productos.add(new NoPerecedero("Cerveza", 600, "Bebida"));
        productos.add(new Perecedero("Huevos", 700, 4));
        productos.add(new NoPerecedero("Galletas", 800, "Panadería"));
        productos.add(new Perecedero("Mantequilla", 900, 5));
        productos.add(new NoPerecedero("Jugo", 1000, "Bebida"));

        for (Producto producto : productos) {
            precioCarrito += producto.calcular(5);
        }

        System.out.println("El precio total del carrito es de: $" + precioCarrito);
    }
}
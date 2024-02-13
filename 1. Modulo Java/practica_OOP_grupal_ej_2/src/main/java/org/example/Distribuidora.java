package org.example;

import java.util.*;

public class Distribuidora {

    public static void main(String[] args) {

        System.out.println("Hello world!");

        Producto producto1 = new Producto("ladrillo", 3);
        Producto producto2 = new Perecedero("Leche", 2, 1);
        Producto producto3 = new NoPerecedero("azucar", 2, "comestible");

        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        double precioTotal = 0;

        for (Producto producto : productos){
            double precioSubTotal = producto.calcular(5);
            precioTotal += precioSubTotal;
            System.out.println("Vendiendo " + 5 + " unidades de " + producto.getNombre());
            System.out.println("Precio unitario: " + producto.getPrecio());
        }

        System.out.println("El precio final es: " + precioTotal);
    }
}
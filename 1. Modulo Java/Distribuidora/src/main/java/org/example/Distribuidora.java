package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new NoPerecedero("Cepillo de dientes", 30d, "Cuidado bucal"));
        productos.add(new NoPerecedero("Toallas higiénicas", 45d, "Higiene personal"));
        productos.add(new NoPerecedero("Desodorante", 60d, "Perfumería"));
        productos.add(new NoPerecedero("Pañuelos de papel", 25d, "Artículos de papel"));
        productos.add(new NoPerecedero("Repelente de insectos", 70d, "Cuidado personal"));

        productos.add(new Perecedero("Frutas frescas", 120d, 2));
        productos.add(new Perecedero("Leche", 80d, 1));
        productos.add(new Perecedero("Carne de pollo", 150d, 1));
        productos.add(new Perecedero("Yogur natural", 90d, 2));
        productos.add(new Perecedero("Huevos", 50d, 3));

        double precioTotal=0;

        for (Producto productoIndividual : productos){
            precioTotal += productoIndividual.calcular(1);
        }

        System.out.println("El precio total es de: " + precioTotal);
    }
}
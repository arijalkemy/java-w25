package org.example;

import java.util.ArrayList;

public class Distribuidora {







    public static void main(String[] args) {

        ArrayList <Producto> productos = new ArrayList<>();

        Producto producto1 = new Producto();
        Producto producto2 = new NoPerecedero("Sal",123.2,"A");
        Producto producto3 = new Perecedero(3,);
        Producto producto4 = new NoPerecedero();
        Producto producto5 = new Producto();

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

    }
}

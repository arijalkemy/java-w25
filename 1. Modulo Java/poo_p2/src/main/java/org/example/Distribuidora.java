package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        double total = 0;
        List<Producto> productoList = new ArrayList<>();
        productoList.add(new Perecedero("Carne",1500.0,2));
        productoList.add(new NoPerecedero("Frijoles",700.0, "Lata"));

        for(Producto producto : productoList){
            total += producto.calcular(5);
            System.out.println(producto.toString());
            System.out.println(producto.calcular(5));
        }
        System.out.println("TOTAL: " + total);

    }
}
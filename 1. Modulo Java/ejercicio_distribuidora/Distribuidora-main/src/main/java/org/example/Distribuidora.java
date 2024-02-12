package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("P1", 2341.2, 2));
        productos.add(new NoPerecedero("P2", 4567.0, "tipo1"));
        productos.add(new Perecedero("P3", 2341.2, 1));
        productos.add(new NoPerecedero("P4", 4567.0, "organico"));
        productos.add(new Perecedero("P5", 2341.2, 3));
        double precioTotal = 0;
        for(Producto p: productos){
            System.out.println(p.toString());
            System.out.println("total de precio: " + p.calcular(5));
            precioTotal += p.calcular(5);
        }
        System.out.println("Total de todas las ventas: ");
        System.out.println(precioTotal);
    }
}

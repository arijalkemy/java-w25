package org.example.models;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void Distribuir(){
        double[] precioTotal = new double[1];

        List<Producto> productoList = new ArrayList<>();
        productoList.add(new Perecedero("Leche", 13000, 2));
        productoList.add(new Perecedero("Carne", 10000, 3));
        productoList.add(new NoPerecedero("Cereal", 5000, "Granos"));
        productoList.add(new NoPerecedero("Arroz", 3000, "Granos"));
        productoList.add(new Perecedero("Huevos", 7000, 1));

        productoList.forEach(product -> precioTotal[0] += product.calcular(3));

        System.out.println("El valor de todos los productos es: "+precioTotal[0]);
    }
}

package org.example.distribuidora_productos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        /*Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos, imprimir el precio
        total al vender 5 productos de cada tipo. Crear los elementos del array con los datos que quieras.*/

        double montoTotal = 0.0;
        double montoActual;

        /*List<Producto> productos = new ArrayList<>(Arrays.asList(
                new NoPerecedero("Atún", 2000.00, "Lata"),
                new NoPerecedero("Arroz", 1000.5, "Almidón"),
                new NoPerecedero("Porotos", 500.25, "Beans"),
                new NoPerecedero("Trigo", 700.00, "Korn"),
                new NoPerecedero("Fideos", 500.00, "Moñito"),
                new Perecedero("Leche", 2000.00, 7),
                new Perecedero("Pan", 1000.5, 5),
                new Perecedero("Pollo", 500.25, 1),
                new Perecedero("Yogur", 700.00, 3),
                new Perecedero("Frutas", 500.00, 2)
        ));*/

        List<Producto> productos2 = new ArrayList<>(Arrays.asList(
                new NoPerecedero("Atún", 1000.00, "Lata"),
                new Perecedero("Pollo", 1000.00, 1),
                new Perecedero("Yogur", 1000.00, 2),
                new Perecedero("Frutas", 1000.00, 3),
                new Perecedero("Pan", 1000.00, 4)
        ));

        int contador = 0;

        for (Producto p : productos2) {
            montoTotal += p.calcular(1);
            montoActual = p.calcular(1);
            contador++;
            System.out.println("El monto de la compra Nº" + contador + " (" + p.getNombre() + ") es: $" + montoActual);
        }
        System.out.println("El monto total de la compra es: $" + montoTotal);

    }
}

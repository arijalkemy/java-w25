package org.example.ejercicio2;

import org.example.ejercicio2.productos.NoPerecedero;
import org.example.ejercicio2.productos.Perecedero;
import org.example.ejercicio2.productos.Producto;

import java.text.MessageFormat;
import java.util.List;

public class Distribuidora {


    public static void main(String[] args){
        List<Producto> productos = List.of(
                new Perecedero("Banano",1000.0,2),
                new Perecedero("Manzana", 800.0, 1),
                new NoPerecedero("Arroz", 2600.0, "Grano"),
                new NoPerecedero("Atun", 4000.0, "Lata"),
                new Producto("producto",700.0)
        );
        double suma = 0.0;
        for(Producto producto:productos){
            suma += producto.calcular(5);
        }
        System.out.println(MessageFormat.format("El precio total de todos los productos es: {0}", suma));
    }
}

package org.bootcamp.Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args){
        List<Producto> listaProductos = new ArrayList<>(Arrays.asList(
                new Perecedero("Carne",10000,3),
                new NoPerecedero("Miel",7500,"NP")
        ));
        listaProductos.stream().forEach(producto ->
        {
            System.out.println("El precio final del producto " +producto.getNombre() + " es: " + producto.calcular(5));
        });
    }
}

package org.clase01_02_24.poo_p2.ejercicio_2;

import jdk.jshell.spi.SPIResolutionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productsArray = new ArrayList<> (Arrays.asList(
                new Perecedero("Leche",10.0,2),
                new Perecedero("Queso crema",10.0,1),
                new NoPerecedero("Arroz",10.0,"Granos")
        ));

        double precioTotal=0;

        for (Producto producto : productsArray) {
            precioTotal += producto.calcular(1);
        }

        System.out.println(precioTotal);
    }
}

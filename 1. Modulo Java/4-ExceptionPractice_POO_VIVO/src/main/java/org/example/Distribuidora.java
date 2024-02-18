package org.example;

import org.example.distribuidora.NoPerecedero;
import org.example.distribuidora.Perecedero;
import org.example.distribuidora.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args)  {
//        metodoExceptions();
        List<Producto> productoList = new ArrayList<>();

        Perecedero perecedero1 = new Perecedero("Mayonesa", 2300.50, 3);
        Perecedero perecedero2 = new Perecedero("Leche", 1950, 1);
        Perecedero perecedero3 = new Perecedero("Tomate", 2499.99,2);

        NoPerecedero noPerecedero1 = new NoPerecedero("Yerba", 2450.80, "Compuesta");
        NoPerecedero noPerecedero2 = new NoPerecedero("Jugo Clight", 1980, "Manzana");
        NoPerecedero noPerecedero3 = new NoPerecedero("Harina", 889.99, "Integral");

        productoList.add(perecedero1);
        productoList.add(perecedero2);
        productoList.add(perecedero3);
        productoList.add(noPerecedero1);
        productoList.add(noPerecedero2);
        productoList.add(noPerecedero3);

        for (Producto producto : productoList) {

        }
    }

    public static void metodoExceptions() throws IllegalAccessException {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        practicaExcepciones.calcularCociente();
    }
}
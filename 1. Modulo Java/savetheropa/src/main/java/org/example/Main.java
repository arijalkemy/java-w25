package org.example;

import org.example.dakar.Carrera;
import org.example.savetheropa.GuardaRopa;
import org.example.savetheropa.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        saveTheRopa();
    }
    private static void saveTheRopa(){
        Prenda prenda1 = new Prenda("nike", "test");
        Prenda prenda2 = new Prenda("adidas", "test2");
        Prenda prenda3 = new Prenda("reebook", "test3");

        ArrayList<Prenda> prendas = new ArrayList<>(List.of(prenda1, prenda2));
        ArrayList<Prenda> prendas2 = new ArrayList<>(List.of(prenda1, prenda3));
        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarRopa(prendas);
        guardaRopa.guardarRopa(prendas2);
        guardaRopa.mostrarPrendas();

        System.out.println("devolverPrenda(1): ");
        guardaRopa.devolverPrenda(1).forEach(System.out::println);
    }
}
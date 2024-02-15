package org.example;

import org.example.model.GuardaRopa;
import org.example.model.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda p1 = new Prenda("Marca A", "Modelo B");
        Prenda p2 = new Prenda("Marca B" , "Modelo B");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(p1);
        prendas.add(p2);

        System.out.println("Guardando Prendas");
        GuardaRopa guardaRopa = new GuardaRopa();
        System.out.println("Su ropa esta guardada con el identificador " + guardaRopa.guardarPrendas(prendas));
        int identificador = 1;
        System.out.println("Sus prendas guardadas con el identificador " + identificador);
        guardaRopa.devolverPrendas(identificador).forEach(System.out::println);
    }
}
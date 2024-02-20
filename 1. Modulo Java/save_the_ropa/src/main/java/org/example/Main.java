package org.example;

import org.example.model.GuardaRopa;
import org.example.model.Prenda;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas1 = List.of(new Prenda("marca1", "Modelo1"),
                                        new Prenda("Marca2", "Modelo2"));
        GuardaRopa guardaRopa = new GuardaRopa();
        Integer numeroId = guardaRopa.guardarPrendas(prendas1);

        System.out.println("Mostrar prendas guardadas");
        guardaRopa.mostrarPrendas();

        System.out.println("===================");
        System.out.println("Devolver prendas");
        if(!guardaRopa.devolverPrendas(numeroId).isEmpty())
            guardaRopa.devolverPrendas(numeroId).forEach(System.out::println);

    }
}
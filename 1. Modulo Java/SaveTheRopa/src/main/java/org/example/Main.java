package org.example;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas = new ArrayList<>();
        List<Prenda> prendas2 = new ArrayList<>();
        prendas.add(new Prenda("Adidas", "Medias"));
        prendas.add(new Prenda("Nike", "Zapatos"));

        GuardaRopa guardaRopa1 = new GuardaRopa();

        System.out.println("Guardado en: " + guardaRopa1.guardarPrenda(prendas));
        guardaRopa1.mostrarPrendas();

        System.out.println("-----------------");
        System.out.println(guardaRopa1.devolverPrenda(0));
    }
}
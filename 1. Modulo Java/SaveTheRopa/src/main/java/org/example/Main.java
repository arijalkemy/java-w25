package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Prenda> listaPrendas = new ArrayList<>();
        List<Prenda> listaPrendas2 = new ArrayList<>();

        Prenda prenda1 = new Prenda("Adidas","Remera");
        Prenda prenda2 = new Prenda("Nike","Pantalon");

        listaPrendas.add(prenda1);
        GuardaRopa.getInstance().guardarPrendas(listaPrendas);
        listaPrendas2.add(prenda2);

    GuardaRopa.getInstance().guardarPrendas(listaPrendas2);

    GuardaRopa.getInstance().mostrarPrendas();

        System.out.println(GuardaRopa.getInstance().devolverPrendas(2));



    }
}
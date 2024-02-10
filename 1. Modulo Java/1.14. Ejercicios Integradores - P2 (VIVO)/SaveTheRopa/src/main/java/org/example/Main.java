package org.example;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Nike", "Zapatillas");
        Prenda prenda2 = new Prenda("Adidas", "Camisa");
        Prenda prenda3 = new Prenda("Topper", "Pantalon");

        Prenda prenda4 = new Prenda("Marca", "Cordones");
        Prenda prenda5 = new Prenda("Asics", "Zapatos");
        Prenda prenda6 = new Prenda("WOW", "Medias");

        GuardaRopa guardaRopa = new GuardaRopa();

        Integer id = guardaRopa.guardarPrendas((Arrays.asList(prenda1, prenda2, prenda3)));
        System.out.println("Prendas guardadas con el id: " + id);


        System.out.println("Contenido del guardaropa: ");
        guardaRopa.mostrarPrendas();

        List<Prenda> prendasRecuperadas = guardaRopa.devolverPrendas(id);
        System.out.println("Prendas recuperadas con el id: " + id);
        prendasRecuperadas.forEach(System.out::println);

        Integer id1 = guardaRopa.guardarPrendas((Arrays.asList(prenda4, prenda5, prenda6)));
        System.out.println("Prendas guardadas con el id: " + id1);


        System.out.println("Contenido del guardaropa: ");
        guardaRopa.mostrarPrendas();

        List<Prenda> prendasRecuperadas1 = guardaRopa.devolverPrendas(id1);
        System.out.println("Prendas recuperadas con el id: " + id1);
        prendasRecuperadas1.forEach(System.out::println);

    }
}
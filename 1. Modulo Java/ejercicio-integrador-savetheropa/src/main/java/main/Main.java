package main;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
        guardaRopa.guardaPrendas(prendas);
        guardaRopa.guardaPrendas(prendas2);
        guardaRopa.mostrarPrendas();

        System.out.println("devolverPrenda(1): ");
        guardaRopa.devolverPrenda(1).forEach(System.out::println);
    }
}
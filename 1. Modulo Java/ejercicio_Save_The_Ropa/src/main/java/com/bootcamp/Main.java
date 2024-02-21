package main.java.com.bootcamp;

import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Prenda> prendas = List.of(new Prenda("marca1", "moedelo1"), new Prenda("marca2", "modelo2"));
        GuardaRopa guardaRopa = new GuardaRopa();

        Integer numeroId = guardaRopa.guardarPrenda(prendas);
        System.out.println("Key: " + numeroId);

        if (!guardaRopa.devolverPrendas(numeroId).isEmpty()) guardaRopa.devolverPrendas(numeroId).forEach(System.out::println);
    }
}

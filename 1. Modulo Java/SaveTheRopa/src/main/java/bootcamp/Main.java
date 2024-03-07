package bootcamp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas = List.of(new Prenda("marca1", "Modelo1"), new Prenda("Marca2", "Modelo2"));
        GuardaRopa guardaRopa = new GuardaRopa();

        Integer numeroId = guardaRopa.guardarPrenda(prendas);
        System.out.println("Key: " + numeroId);

        if(!guardaRopa.devolverPrendas(numeroId).isEmpty()) guardaRopa.devolverPrendas(numeroId).forEach(System.out::println);

    }
}
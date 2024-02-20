package org.example.clases;

import org.example.clases.GuardaRopa;
import org.example.clases.Prenda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GuardaRopa unGuardaRopa = new GuardaRopa();
        Prenda prenda = new Prenda();

        List<Prenda> prendasDaniela = List.of(
                new Prenda("ADIDAS", "UltraBoost"),
                new Prenda("ADIDAS", "Messi"),
                new Prenda("Nike", "CR7"),
                new Prenda("Puma", "Bolt"));

        Integer keyPrendaGuardada = unGuardaRopa.guardarPrendas(prendasDaniela);

        unGuardaRopa.mostrarPrendas();

        List<Prenda> prendas = unGuardaRopa.devolverPrendas(keyPrendaGuardada);

        unGuardaRopa.mostrarPrendas();
    }
}

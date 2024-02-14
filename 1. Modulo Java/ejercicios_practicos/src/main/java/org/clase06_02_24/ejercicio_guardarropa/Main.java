package org.clase06_02_24.ejercicio_guardarropa;


import org.clase06_02_24.ejercicio_dakar.Carrera;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardarRopa guardarRopa = new GuardarRopa();
        List<Prenda> lista = Arrays.asList(
                new Prenda("Nike", "Air"),
                new Prenda("Adidas", "Predator")
        );
        Integer id = guardarRopa.guardarPrendas(lista);
        System.out.println(guardarRopa.devolverPendas(id));


    }
}

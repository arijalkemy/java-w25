package org.example;

import org.example.dakar.dominio.Carrera;
import org.example.ropa.dominio.GuardarRopa;
import org.example.ropa.dominio.Prenda;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // sala 8
        GuardarRopa guardarRopa = new GuardarRopa();
        List<Prenda> lista = Arrays.asList(
                new Prenda("Nike", "Air"),
                new Prenda("Adidas", "Predator")
        );
        Integer id = guardarRopa.guardarPrendas(lista);
        System.out.println(guardarRopa.devolverPendas(id));

        //Dakar

        Carrera carrera1 = Carrera.builder()
                .nombre("Carrera 1")
                .distancia(4000)
                .cantidadDeVehiculosPermitidos(2)
                .premioEnDolares(10000)
                .build();

        carrera1.darDeAltaAuto(100, 20, 90, "ABC123");
        carrera1.darDeAltaMoto(200, 30, 190, "XYZ890");

        System.out.println("Ganador de " + carrera1.getNombre() + ": " + (carrera1.ganador().isPresent() ? carrera1.ganador().get() : "No hay ganador"));
    }
}
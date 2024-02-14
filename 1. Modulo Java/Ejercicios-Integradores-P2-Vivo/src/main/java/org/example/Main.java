package org.example;

import org.example.dakar.dominio.Auto;
import org.example.dakar.dominio.Carrera;
import org.example.dakar.dominio.SocorristaAuto;
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

        Carrera carrera = new Carrera(4000, 10000, "Carrera 1", 2);

        carrera.darDeAltaAuto(100, 20, 90, "ABC123");
        carrera.darDeAltaMoto(200, 30, 190, "XYZ890");

        System.out.println("Ganador de " + carrera.getNombre() + ": " + (carrera.ganador().isPresent() ? carrera.ganador().get() : "No hay ganador"));

        final String patenteNoExistente = "Patente no existente";
        carrera.socorrerAuto("ABC123");
        carrera.socorrerAuto(patenteNoExistente);
        carrera.socorrerMoto("XYZ890");
        carrera.socorrerMoto(patenteNoExistente);

        carrera.eliminarVehiculo(new Auto(100, 20, 90, "ABC123"));
        System.out.println(carrera.getListaDeVehiculos());
        carrera.eliminarVehiculoConPatente("XYZ890");
        System.out.println(carrera.getListaDeVehiculos());
    }
}
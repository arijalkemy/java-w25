package org.example;

import org.example.model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        carrera.setDistancia(10000);
        carrera.setNombre("Copa Piston");
        carrera.setCantidadDeVehiculosPermitidos(20);
        carrera.setPremioEnDolares(1000000);
        carrera.setVehiculos(List.of(
                new Auto(120, 80, 180, "ABC123"),
                new Auto(150, 60, 140, "ABD124"),
                new Moto(100, 70, 210, "DAC101"),
                new SocorristaVehiculo(120, 80, 180, "****", 2000, 4),
                new SocorristaMoto(120, 80, 180, "****", 2000, 4)
        ));
        System.out.println("Participantes de la carrera " + carrera.getVehiculos().size() + "/" + carrera.getCantidadDeVehiculosPermitidos());
        carrera.darDeAltaMoto(100, 70, 210, "DAC101B");
        carrera.darDeAltaAuto(120, 80, 180, "ABC123B");
        System.out.println("Participantes de la carrera " + carrera.getVehiculos().size() + "/" + carrera.getCantidadDeVehiculosPermitidos());

        System.out.println("Accidente entre un auto y una moto");
        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("DAC101B");
        System.out.println("\nEl ganador es: " + carrera.determinarGanador());


    }
}
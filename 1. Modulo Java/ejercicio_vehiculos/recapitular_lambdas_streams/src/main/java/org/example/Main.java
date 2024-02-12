package org.example;

import java.util.*;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {

        //SALA 11

        //-------------------------------------------------EJERCICIO 2-------------------------------------------------

        Garaje garaje = new Garaje();

        List<Vehiculo> vehiculos = new ArrayList<>();

        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950);

        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        garaje.vehiculos = vehiculos;

        //-------------------------------------------------EJERCICIO 3-------------------------------------------------

        vehiculos.sort(comparingDouble(Vehiculo::getCosto));
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Modelo: " + vehiculo.getModelo() + ", Marca: " + vehiculo.getMarca() + ", Costo: " + vehiculo.getCosto());
        }

        //-------------------------------------------------EJERCICIO 5-------------------------------------------------

        List<Vehiculo> vehiculosMenorOIgualA1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .toList();

        List<Vehiculo> vehiculosMayorOIgualA1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();

        System.out.println("Imprimimos vehiculos menor o igual a 1000:");
        for (Vehiculo vehiculo : vehiculosMenorOIgualA1000) {
            System.out.println("Modelo: " + vehiculo.getModelo() + ", Marca: " + vehiculo.getMarca()
                    + ", Costo: " + vehiculo.getCosto());
        }
        System.out.println("Imprimimos vehiculos mayor o igual a 1000:");
        for (Vehiculo vehiculo : vehiculosMayorOIgualA1000) {
            System.out.println("Modelo: " + vehiculo.getModelo() + ", Marca: " + vehiculo.getMarca()
                    + ", Costo: " + vehiculo.getCosto());
        }

        double promedio = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println("El promedio de costo es de : " + promedio);

        //-------------------------------------------------EJERCICIO 4-------------------------------------------------

        System.out.println("VEHICULO POR MARCA Y COSTO");
        vehiculos.sort(comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto));
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Modelo: " + vehiculo.getModelo() + ", Marca: " + vehiculo.getMarca() + ", Costo: " + vehiculo.getCosto());
        }

        //-------------------------------------------------CUSTOM-------------------------------------------------

        // stream: promedio - suma total costos - cant. vehiculos en lista

        System.out.println("FILTRO CUSTOM");

        vehiculos.stream()
                .sorted(comparing(Vehiculo::getModelo).thenComparingDouble(Vehiculo::getCosto).reversed())
                .filter(vehiculo -> vehiculo.getCosto() < 2000)
                .filter(vehiculo -> Objects.equals(vehiculo.getMarca(), "Fiat"))
                .toList()
                .forEach(vehiculo -> System.out.println(vehiculo.toString()));

        double montoTotal = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .sum();
            System.out.println("El monto de todos los vehículos es: " + montoTotal);

            /*int cantidadVehiculos = vehiculos.stream()
                    .mapToInt(vehiculos.size());*/

        //jevy: ordenar 2 garages de menor a mayor segun cant. vehiculos
        /*garajes.stream()
                .sorted(Comparator.comparingInt(garage -> garage.getVehiculos().size()))
                .forEach(System.out::println);*/
    }
}

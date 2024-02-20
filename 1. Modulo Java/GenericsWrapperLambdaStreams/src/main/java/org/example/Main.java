package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1300));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(vehiculos);

        vehiculos.sort( (v1,v2) -> Double.compare(v1.getCosto(), v2.getCosto()) );
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }

        System.out.println("*************************************************************");

        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));

        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }

        List<Vehiculo> vehiculosMenor1000 = vehiculos.stream().filter(v -> v.getCosto() <= 1000).collect(Collectors.toList());
        List<Vehiculo> vehiculosMayor1000 = vehiculos.stream().filter(v -> v.getCosto() > 1000).collect(Collectors.toList());

        double promedioPrecios = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);

        System.out.println("\nVehiculos con precio menor o igual a 1000: ");
        vehiculosMenor1000.forEach(System.out::println);

        System.out.println("\nVehiculos con precio mayor a 1000: ");
        vehiculosMayor1000.forEach(System.out::println);

        System.out.println("\nPromedio de precios de todos los vehiculos: " + promedioPrecios);

    }
}
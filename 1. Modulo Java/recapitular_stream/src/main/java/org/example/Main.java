package org.example;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add( new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add( new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add( new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add( new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add( new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add( new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add( new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add( new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add( new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add( new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add( new Vehiculo("Logan", "Renault", 950));

        Garaje garaje = new Garaje(1,vehiculos);
        List<Vehiculo> vehiculosGarage = garaje.getVehiculos();

        System.out.println("-------------------Vehiculos ordenados por precio------------------");
        vehiculosGarage.stream().sorted(comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("-------------------Vehiculos ordenados por precio y marca------------------");
        vehiculosGarage.stream().sorted(comparingDouble(Vehiculo::getCosto))
                                .sorted(comparing(Vehiculo::getMarca))
                                .forEach(System.out::println);

        System.out.println("-------------------Vehiculos menor a 1000-------------------");
        vehiculosGarage.stream().filter( v -> v.getCosto() < 1000).forEach(System.out::println);

        System.out.println("-------------------Vehiculos mayor o igual a 1000-------------------");
        vehiculosGarage.stream().filter( v -> v.getCosto() >= 1000).forEach(System.out::println);


        double promedio = vehiculosGarage.stream().mapToDouble(Vehiculo::getCosto)
                                        .average()
                                        .orElse(0.0);

        System.out.println("Promedio de toda la lista de vehiculos: " + promedio);
    }
}

package org.example;

import org.example.clases.Garaje;
import org.example.clases.Vehiculo;

import java.util.Comparator;
import java.util.List;

public class Main {
        public static void main(String[] args) {
                // Ejercicio 2
                List<Vehiculo> vehiculos = List.of(
                        new Vehiculo("Ford", "Fiesta", 1000),
                        new Vehiculo("Ford", "Focus", 1200),
                        new Vehiculo("Ford", "Explorer", 2500),
                        new Vehiculo("Fiat", "Uno", 500),
                        new Vehiculo("Fiat", "Cronos", 1000),
                        new Vehiculo("Fiat", "Torino", 1250),
                        new Vehiculo ("Chevrolet", "Aveo", 1250),
                        new Vehiculo ("Chevrolet", "Spin", 2500),
                        new Vehiculo ("Toyota", "Corola", 1200),
                        new Vehiculo ("Toyota", "Fortuner", 3000),
                        new Vehiculo ("Renault", "Logan", 950)
                );
        
                Garaje garaje = new Garaje(1, vehiculos);
        
                // Ejercicio 3
                System.out.println("#### Ejercicio 3 ####");
                garaje.getVehiculoList().stream()
                        .sorted(Comparator.comparing(Vehiculo::getCosto))
                        .map(Vehiculo::toString).forEach(System.out::println);
                System.out.println();
        
                // Ejercicio 4
                System.out.println("#### Ejercicio 4 ####");
                garaje.getVehiculoList().stream()
                        .sorted(Comparator.comparing(Vehiculo::getMarca)
                                .thenComparing(Vehiculo::getCosto))
                        .map(Vehiculo::toString).forEach(System.out::println);
                System.out.println();
        
                // Ejercicio 5
                System.out.println("#### Ejercicio 5 ####");
                garaje.getVehiculoList().stream()
                        .filter(vehiculo -> vehiculo.getCosto() < 1000)
                        .map(Vehiculo::toString)
                        .forEach(System.out::println);
                System.out.println();
                garaje.getVehiculoList().stream()
                        .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                        .map(Vehiculo::toString)
                        .forEach(System.out::println);
                System.out.println();
                garaje.getVehiculoList().stream()
                        .mapToDouble(Vehiculo::getCosto)
                        .average()
                        .ifPresent(System.out::println);
        
                // Ejercicio 6 (propuesta)
                System.out.println("#### Ejercicio propuesto 1 ####");
                garaje.getVehiculoList().stream()
                        .min(Comparator.comparing(Vehiculo::getCosto))
                        .ifPresent(barato -> System.out.println("Vehículo más barato: " + barato));
                garaje.getVehiculoList().stream()
                        .max(Comparator.comparing(Vehiculo::getCosto))
                        .ifPresent(caro -> System.out.println("Vehículo más caro: " + caro));
                System.out.println();
        
                System.out.println("#### Ejercicio propuesto 2 ####");
                garaje.getVehiculoList().stream()
                        .filter(vehiculo -> vehiculo.getCosto() < 1000)
                        .forEach(vehiculo -> vehiculo.setGama("Baja"));
                garaje.getVehiculoList().stream()
                        .filter(vehiculo -> vehiculo.getCosto() >= 1000 && vehiculo.getCosto() < 2000)
                        .forEach(vehiculo -> vehiculo.setGama("Media"));
                garaje.getVehiculoList().stream()
                        .filter(vehiculo -> vehiculo.getCosto() >= 2000)
                        .forEach(vehiculo -> vehiculo.setGama("Alta"));
        
                garaje.getVehiculoList().forEach(vehiculo -> System.out.println(vehiculo.toString()));
        }
}
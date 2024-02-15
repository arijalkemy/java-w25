package org.example;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1);
        garaje.getVehiculosList().add(new Vehiculo("Ford", "Fiesta", 1000));
        garaje.getVehiculosList().add(new Vehiculo("Ford", "Focus", 1200));
        garaje.getVehiculosList().add(new Vehiculo("Ford", "Explorer", 1500));
        garaje.getVehiculosList().add(new Vehiculo("Fiat", "Uno", 500));
        garaje.getVehiculosList().add(new Vehiculo("Fiat", "Cronos", 1000));
        garaje.getVehiculosList().add(new Vehiculo("Fiat", "Torino", 1250));
        garaje.getVehiculosList().add(new Vehiculo("Chevrolet", "Aveo", 1250));
        garaje.getVehiculosList().add(new Vehiculo("Chevrolet", "Spin", 2500));
        garaje.getVehiculosList().add(new Vehiculo("Toyota", "Corola", 1200));
        garaje.getVehiculosList().add(new Vehiculo("Toyota", "Fortuner", 3000));
        garaje.getVehiculosList().add(new Vehiculo("Renault", "Logan", 950));


        System.out.println("Lista sin ordenar");
        garaje.getVehiculosList().forEach(System.out::println);
        System.out.println("\n");
        System.out.println("\n");
        garaje.getVehiculosList().sort((a,b) -> a.getCosto().compareTo(b.getCosto()));
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Lista ordenada por precio Forma 1");
        garaje.getVehiculosList().forEach(System.out::println);

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Lista ordenada por precio Forma 2");
        garaje.getVehiculosList().stream().sorted((a,b) -> a.getCosto().compareTo(b.getCosto())).forEach(System.out::println);
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("Ordenado por marca y precio");

        garaje.getVehiculosList().stream().sorted(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("Ordenado por marca y precio 2");

        garaje.getVehiculosList().stream().sorted(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto)).toList();
        System.out.println("\n");
        System.out.println("\n");
        garaje.getVehiculosList()
                .stream().filter(a -> a.getCosto()< 1000).forEach(System.out::println);
        System.out.println("\n");System.out.println("\n");
        garaje.getVehiculosList()
                .stream().filter(a -> a.getCosto()< 1000).forEach(System.out::println);


        garaje.getVehiculosList()
                .stream().mapToInt(Vehiculo::getCosto)
                .average().ifPresent(promedio -> System.out.println("El promedio es " + promedio));

    }
}
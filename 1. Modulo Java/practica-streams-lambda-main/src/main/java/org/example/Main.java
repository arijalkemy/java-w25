package org.example;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
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
        Garage garage = new Garage(7,vehiculos);
        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto));
        for (Vehiculo vehiculo:vehiculos){
            System.out.println(vehiculo);

        }
        List<Vehiculo> vehiculosMenor1000 = vehiculos.stream()
                .filter(v -> v.getCosto() <= 1000)
                .toList();

        List<Vehiculo> vehiculosMayor1000 = vehiculos.stream()
                .filter(v -> v.getCosto() >= 1000)
                .toList();

        double promedioPrecios = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println("Vehículos con precio no mayor a 1000:");
        for (Vehiculo vehiculo : vehiculosMenor1000) {
            System.out.println(vehiculo);
        }

        System.out.println("\nVehículos con precio mayor o igual a 1000:");
        for (Vehiculo vehiculo : vehiculosMayor1000) {
            System.out.println(vehiculo);
        }

        System.out.println("\nPromedio total de precios: " + promedioPrecios);

        //EJERCICIO EXTRA
        System.out.println("EJERCICIO EXTRA:");
        vehiculos.stream().filter(x -> x.getModelo().equals("Fiat")).forEach(System.out::println);
    }
}
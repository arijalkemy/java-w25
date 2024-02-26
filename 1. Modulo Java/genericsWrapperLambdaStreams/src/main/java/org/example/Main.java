package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Garaje garaje1 = new Garaje(new ArrayList<>());

        garaje1.addVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        garaje1.addVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garaje1.addVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garaje1.addVehiculo(new Vehiculo("Fiat", "Uno", 500));
        garaje1.addVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        garaje1.addVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        garaje1.addVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        garaje1.addVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
        garaje1.addVehiculo(new Vehiculo("Toyoya", "Corola", 1200));
        garaje1.addVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
        garaje1.addVehiculo(new Vehiculo("Renault", "Logan", 950));

        garaje1.getListaVehiculo().sort((x, y) -> Double.compare(x.getCosto(), y.getCosto()));
        garaje1.getListaVehiculo().forEach(y -> System.out.println(y));

        System.out.println("-------------");
        garaje1.getListaVehiculo().stream().sorted((x, y) -> {
            if (x.getCosto() > y.getCosto()) {
                return 1;
            } else if (x.getCosto() < y.getCosto()) {
                return -1;
            } else {
                return x.getMarca().compareTo(y.getMarca());
            }
        }).forEach(System.out::println);
        System.out.println("-------------");
        garaje1.getListaVehiculo().stream().filter((x) -> x.getCosto() < 1000 ).forEach(System.out::println);
        System.out.println("-------------");
        garaje1.getListaVehiculo().stream().filter((x) -> x.getCosto() >= 1000 ).forEach(System.out::println);
        System.out.println("-------------");
        System.out.println(garaje1.getListaVehiculo().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble());
    }
}
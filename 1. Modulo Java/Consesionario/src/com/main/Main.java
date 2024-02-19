package com.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();
        listaVehiculo.add(new Vehiculo("Ford","Fiesta",1000));
        listaVehiculo.add(new Vehiculo("Ford","Focus",1200));
        listaVehiculo.add(new Vehiculo("Ford","Explorer",2500));
        listaVehiculo.add(new Vehiculo("Fiat","Uno",500));
        listaVehiculo.add(new Vehiculo("Fiat","Cronos",1000));
        listaVehiculo.add(new Vehiculo("Fiat","Torino",1250));
        listaVehiculo.add(new Vehiculo("Chevrolet","Aveo",1250));
        listaVehiculo.add(new Vehiculo("Chevrolet","Spin",2500));
        listaVehiculo.add(new Vehiculo("Toyota","Corola",1200));
        listaVehiculo.add(new Vehiculo("Toyota","Fortuner",3000));
        listaVehiculo.add(new Vehiculo("Renault","Logan",950));

        Garaje garaje = new Garaje(1, listaVehiculo);

        //3
        System.out.println("--- ORDEN POR COSTO ---");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        //4
        System.out.println("--- ORDEN POR MARCA Y COSTO ---");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        //5
        System.out.println("--- COSTO MENOR A 1000 ---");
        List<Vehiculo> vehiculosMenorMil = garaje.getVehiculos().stream()
                                                .filter( x -> x.getCosto() < 1000).collect(Collectors.toList());
        vehiculosMenorMil.forEach(System.out::println);

        System.out.println("--- COSTO MAYOR IGUAL A 1000 ---");
        List<Vehiculo> vehiculosMayorMil = garaje.getVehiculos().stream()
                .filter( x -> x.getCosto() >= 1000).collect(Collectors.toList());
        vehiculosMayorMil.forEach(System.out::println);
        System.out.println("--- PROMEDIO ---");
        OptionalDouble promdioCosto = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average();
        System.out.println(promdioCosto);

    }
}

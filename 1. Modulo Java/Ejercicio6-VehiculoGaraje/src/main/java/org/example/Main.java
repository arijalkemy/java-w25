package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        listaVehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        listaVehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        listaVehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        listaVehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        listaVehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        listaVehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        listaVehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        listaVehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        listaVehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        listaVehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garaje garaje = new Garaje(1, listaVehiculos);

        //Ordenados por precio de menor a mayor
        System.out.println("--- Listado de vehiculos ordenados de menor a mayor costo: ");
        List<Vehiculo> vehiculosOrdenadosPrecio = new ArrayList<>(listaVehiculos);
                vehiculosOrdenadosPrecio.stream()
                .sorted((vehiculo1, vehiculo2) -> Double.compare(vehiculo1.getCosto(), vehiculo2.getCosto()))
                .forEach(vehiculo -> {
                    System.out.println(vehiculo.getMarca()+" "+vehiculo.getModelo()+" "+vehiculo.getCosto());
                });

        //Ordenados por marca y luego precio
        System.out.println("--- Listado de vehiculos ordenados por marca y de menor a mayor costo: ");
        List<Vehiculo> vehiculosOrdenadosMarcaPrecio = new ArrayList<>(listaVehiculos);
                vehiculosOrdenadosMarcaPrecio.stream()
                        .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                        .forEach(vehiculo -> {
                            System.out.println(vehiculo.getMarca()+" "+vehiculo.getModelo()+" "+vehiculo.getCosto());
                        });

        //Extraer lista con precio igual o menor a 1000
        System.out.println("---Listado con vehiculos con costo de  hasta 1000: ");
        List<Vehiculo> listaVehiculosMenoresIgual1000 = new ArrayList<>(listaVehiculos);
                listaVehiculosMenoresIgual1000.stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .forEach(vehiculo -> {
                    System.out.println(vehiculo.getMarca()+" "+vehiculo.getModelo()+" "+vehiculo.getCosto());
                });

        //Extraer lista con precio igual o mayor a 1000
        System.out.println("---Listado con vehiculos con costo desde 1000: ");
        List<Vehiculo> listaVehiculosMayoresIgual1000 = new ArrayList<>(listaVehiculos);
        listaVehiculosMayoresIgual1000.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(vehiculo -> {
                    System.out.println(vehiculo.getMarca()+" "+vehiculo.getModelo()+" "+vehiculo.getCosto());
                });

        //Promedio total de precios de los vehiculos
        System.out.println("---El promedio de precio de los vehiculos es: ");
        double promedioPrecio = listaVehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println("El promedio de precios es: "+promedioPrecio);
    }
}
package org.example;

import org.example.vehiculo.Garaje;
import org.example.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculosGaraje =  new ArrayList<>();

        vehiculosGaraje.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculosGaraje.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculosGaraje.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculosGaraje.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculosGaraje.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculosGaraje.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculosGaraje.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculosGaraje.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculosGaraje.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculosGaraje.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculosGaraje.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garajeAtos = new Garaje(1,vehiculosGaraje);

        //punto 3
        garajeAtos.getVehiculos()
                .stream()
                .sorted((vehiculo1,vehiculo2)->Integer.compare(vehiculo1.getCosto(),vehiculo2.getCosto()))
                //.sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .forEach(System.out::println);

        //punto 4
        System.out.println("punto 4 ------------");
        System.out.println("");
        garajeAtos.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(
                                Vehiculo::getMarca
                ).thenComparingInt(Vehiculo::getCosto))
                //.sorted((vehiculo1,vehiculo2)-> vehiculo1.getMarca().compareToIgnoreCase(vehiculo2.getMarca()))
                //.sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .forEach(System.out::println);

        //punto 5
        System.out.println("punto 5 ------------");
        System.out.println("");
        System.out.println("punto 5.1");

        garajeAtos.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("punto 5.2");
        System.out.println("");

        garajeAtos.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("punto 5.3");
        System.out.println("");

        double average = garajeAtos.getVehiculos()
                .stream()
                .mapToInt(vehiculo ->vehiculo.getCosto())
                .average().orElseThrow();

        System.out.println("promedio : " + average);


        System.out.println("punto custom extras");
        System.out.println("");

        garajeAtos.getVehiculos()
                .stream()
                .forEach(vehiculo ->System.out.println(vehiculo.getMarca()+" - "+vehiculo.getModelo()));

        garajeAtos.getVehiculos()
                .stream()
                .map(vehiculo -> (vehiculo.getMarca()+" - "+vehiculo.getModelo()))
                .forEach(System.out::println);



    }
}
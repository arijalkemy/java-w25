package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> listaVehicular = new ArrayList<>();

        Garaje garaje1 = new Garaje("1DARE234", listaVehicular);

        listaVehicular.add(new Vehiculo("Ford", "Fiesta", 1000));
        listaVehicular.add(new Vehiculo("Ford", "Focus", 1200));
        listaVehicular.add(new Vehiculo("Ford", "Explorer", 2500));

        listaVehicular.add(new Vehiculo("Fiat", "Uno", 500));
        listaVehicular.add(new Vehiculo("Fiat", "Cronos", 1000));
        listaVehicular.add(new Vehiculo("Fiat", "Torino", 1250));

        listaVehicular.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        listaVehicular.add(new Vehiculo("Chevrolet", "Sprint", 2500));

        listaVehicular.add(new Vehiculo("Toyota", "Corolla", 1200));
        listaVehicular.add(new Vehiculo("Toyota", "Fortuner", 3000));

        listaVehicular.add(new Vehiculo("Renault", "Logan", 950));


        System.out.println("---------------------------------------------------------------");
        garaje1.getVehiculoList().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        garaje1.getVehiculoList().stream().sorted(Comparator.comparing(Vehiculo::getMarca)).sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        garaje1.getVehiculoList().stream().filter(v -> v.getCosto() < 1000).forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        garaje1.getVehiculoList().stream().filter(v -> v.getCosto()>=1000).forEach(System.out::println);
        System.out.println("Avg: "+ garaje1.getVehiculoList().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0));


    }
}
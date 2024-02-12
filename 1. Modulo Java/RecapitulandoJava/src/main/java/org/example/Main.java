package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> lista = new ArrayList<>();
        Vehiculo fiesta = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo focus = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo explorer = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo uno = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo cronos = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo torino = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo aveo = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo spin = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo corola = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo fortuner = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo logan = new Vehiculo("Logan", "Renault", 950);

        lista.add(fiesta);
        lista.add(focus);
        lista.add(explorer);
        lista.add(uno);
        lista.add(cronos);
        lista.add(torino);
        lista.add(aveo);
        lista.add(spin);
        lista.add(corola);
        lista.add(fortuner);
        lista.add(logan);

        Garage listaAutos = new Garage(1, lista);

        System.out.println("Lista ordenada por costos");

        listaAutos.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("--------Lista ordenada por precio y marca---------");
        listaAutos.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("Lista con vehiculos con precios menor a 1000");
        listaAutos.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("--------Lista con vehiculos con precios mayor o igual a 1000---------");
        listaAutos.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("---------Promedio de los costos-----------");
        double prom = listaAutos.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto).average().orElse(0.0);
        System.out.println("pepito = " + prom);

    }
}
package org.clase02_02_24.segunda_parte;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000.0);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200.0);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500.0);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500.0);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000.0);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250.0);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250.0);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500.0);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200.0);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000.0);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950.0);

        List<Vehiculo> vehiculoList = Arrays.asList(vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5, vehiculo6, vehiculo7,
                vehiculo8, vehiculo9, vehiculo10, vehiculo11);

        Garage garage = new Garage(1, vehiculoList);

        System.out.println("\n------- Lista de vehiculos ordenada por precio de menor a mayor ---------\n");
        List<Vehiculo> vehiculoList2 = vehiculoList.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .toList();
        vehiculoList2.forEach(System.out::println);


        System.out.println("\n------- Lista de vehiculos ordenada por marca y por precio ---------\n");
        List<Vehiculo> vehiculoList3 = vehiculoList.stream().sorted(Comparator.comparing(Vehiculo::getMarca).
                thenComparing(Vehiculo::getCosto)).toList();

        vehiculoList3.forEach(System.out::println);

        System.out.println("\n------- Lista de vehiculos con precio menor a $1000 ---------\n");
        List<Vehiculo> vehiculoList4 = vehiculoList.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).toList();
        vehiculoList4.forEach(System.out::println);

        System.out.println("\n------- Lista de vehiculos con precio mayor o igual a $1000 ---------\n");
        List<Vehiculo> vehiculoList5 = vehiculoList.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).toList();
        vehiculoList5.forEach(System.out::println);

        System.out.println("\n------- Precio primedio de todos los vehiculos ---------\n");
        System.out.println("$ " + Math.round(vehiculoList.stream().collect(Collectors.averagingDouble(Vehiculo::getCosto))));

        System.out.println("\n------- Buscador de precio por modelo ---------\n");
        Scanner scanner = new Scanner(System.in);
        String modelo = scanner.next();
        Double precioBuscado;
        try {
            precioBuscado = vehiculoList.stream().filter(vehiculo -> vehiculo.getModelo().equalsIgnoreCase(modelo)).findAny().get().getCosto();
        } catch (NoSuchElementException e){
            throw new IllegalArgumentException("El modelo ingresado no existe");
        }

        System.out.println("El precio buscado es de $" + precioBuscado);
    }


}

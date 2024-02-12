package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Garaje garaje = new Garaje(1);
        garaje.getVehiculos().add(new Vehiculo("Fiesta", "Ford", 1000));
        garaje.getVehiculos().add(new Vehiculo("Focues", "Ford", 1200));
        garaje.getVehiculos().add(new Vehiculo("Explorer", "Ford", 2500));
        garaje.getVehiculos().add(new Vehiculo("Uno", "Fiat", 500));
        garaje.getVehiculos().add(new Vehiculo("Cronos", "Fiat", 1000));
        garaje.getVehiculos().add(new Vehiculo("Torino", "Fiat", 1250));
        garaje.getVehiculos().add(new Vehiculo("Aveo", "Chevrolet", 1250));
        garaje.getVehiculos().add(new Vehiculo("Croos", "Fiat", 10200));
        garaje.getVehiculos().add(new Vehiculo("Corsa", "Fiat", 4500));
        garaje.getVehiculos().add(new Vehiculo("Torino", "Fiat", 231213));
        garaje.getVehiculos().add(new Vehiculo("Logan", "Renault", 32322));
        garaje.getVehiculos().add(new Vehiculo("Focus", "Marca1", 4000));
        garaje.getVehiculos().add(new Vehiculo("Corola", "Toyota", 7000));
        garaje.getVehiculos().add(new Vehiculo("Aveo", "Chevrolet", 34500));

     //   garaje.getVehiculos().sort((e1,e2) -> Double.compare((e1.getCosto()),(e2.getCosto())))

        // Ejercicio 3
        imprimirVehiculosOrdenadosPorPrecios(new ArrayList<>(garaje.getVehiculos()));
        // Ejercicio 4
        imprimirPorMarca(new ArrayList<>(garaje.getVehiculos()));
        //Ejercicio 5
        imprimirVehiculosConPrecioMayorOIgualA1000(new ArrayList<>(garaje.getVehiculos()));
        imprimirMenorA1000(new ArrayList<>(garaje.getVehiculos()));
        System.out.println(promedio(new ArrayList<>(garaje.getVehiculos())));
        System.out.println(promedioStream(new ArrayList<>(garaje.getVehiculos())));
        searchFord(new ArrayList<>(garaje.getVehiculos()));
    }

    private static void imprimirVehiculosOrdenadosPorPrecios(List<Vehiculo> vehiculos){
        System.out.println("Vehiculos por Precio:");
        vehiculos.sort(Comparator.comparingDouble(Vehiculo::getCosto));
        vehiculos.forEach(vehiculo->System.out.println(vehiculo.toString()));
    }
    private static void imprimirPorMarca(List<Vehiculo> vehiculos){
        System.out.println("Vehiculos por marca y precio");
        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing((Vehiculo::getCosto)));
        vehiculos.forEach(vehiculo->System.out.println(vehiculo.toString()));
    }
    private static void imprimirVehiculosConPrecioMayorOIgualA1000(List<Vehiculo> vehiculos){
        System.out.println("Vehiculos Mayores e iguales a 1000");
        vehiculos.stream().filter(vehiculo->vehiculo.getCosto()>=1000)
                .forEach(vehiculo->System.out.println(vehiculo.toString()));
    }

    private  static  void imprimirMenorA1000(List<Vehiculo> vehiculos){
        System.out.println("Vehiculos Menores a 1000");
        vehiculos.stream().filter(vehiculo->vehiculo.getCosto()<1000)
                .forEach(vehiculo->System.out.println(vehiculo.toString()));
    }
    private static double promedio(List<Vehiculo> vehiculos){
        double sumaDePrecios = 0;
        for (Vehiculo vehiculo: vehiculos){
            sumaDePrecios += vehiculo.getCosto();
        }

        return sumaDePrecios / vehiculos.size();

    }


    private static double promedioStream(List<Vehiculo> vehiculos) {
        return vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
    }
    private static void searchFord(List<Vehiculo> vehiculos) {
         vehiculos.stream().filter( e -> "Ford".equals((e.getMarca())))
                .forEach(e -> System.out.println(e.getModelo()+" Precio "+ e.getCosto()));
    }

}
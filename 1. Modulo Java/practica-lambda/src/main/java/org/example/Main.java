package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1);

        garaje.agregarVehiculo(new Vehiculo("Ford","Focus", 1200));
        garaje.agregarVehiculo(new Vehiculo("Ford","Fiesta", 1000));

        garaje.agregarVehiculo(new Vehiculo("Ford","Explorer", 2500));
        garaje.agregarVehiculo(new Vehiculo("Fiat","Uno", 500));
        garaje.agregarVehiculo(new Vehiculo("Fiat","Cronos", 1000));
        garaje.agregarVehiculo(new Vehiculo("Fiat","Torino", 1250));
        garaje.agregarVehiculo(new Vehiculo("Chevrolet","Aveo", 1250));
        garaje.agregarVehiculo(new Vehiculo("Chevrolet","Spin", 2500));
        garaje.agregarVehiculo(new Vehiculo("Toyota","Corola", 1200));
        garaje.agregarVehiculo(new Vehiculo("Toyota","Fortuner", 3000));
        garaje.agregarVehiculo(new Vehiculo("Renault","Logan", 950));

        /*garaje.getVehiculos().sort((v1, v2) -> Double.compare(v1.getPrecio(), v2.getPrecio()));
        garaje.getVehiculos().forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + ": " + v.getPrecio()));*/

        garaje.getVehiculos().sort((v1, v2) -> {
            if (v1.getMarca().equals(v2.getMarca())) {
                return Double.compare(v1.getPrecio(), v2.getPrecio());
            }

            return v1.getMarca().compareTo(v2.getMarca());
        });
        garaje.getVehiculos().forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + ": " + v.getPrecio()));

//        ArrayList<Vehiculo> vehiculosFiltrados1 = new ArrayList<>();
//        garaje.getVehiculos().stream().filter(v -> v.getPrecio() < 1000).forEach(vehiculosFiltrados1::add);
//        System.out.println("Vehiculos con precio menor a 1000:");
//        vehiculosFiltrados1.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + ": " + v.getPrecio()));
//        System.out.println("Promedio: " + vehiculosFiltrados1.stream().mapToDouble(Vehiculo::getPrecio));
//
//        ArrayList<Vehiculo> vehiculosFiltrados2 = new ArrayList<>();
//        garaje.getVehiculos().stream().filter(v -> v.getPrecio() >= 1000).forEach(vehiculosFiltrados2::add);
//        System.out.println("Vehiculos con precio mayor o igual a 1000:");
//        vehiculosFiltrados2.forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + ": " + v.getPrecio()));

        // Obtener el promedio x marca de auto
        garaje
            .getVehiculos()
            .stream()
            .filter(v -> v.getMarca().equals("Ford"))
            .sorted((v1,v2) -> Double.compare(v1.getPrecio(), v2.getPrecio()))
            .forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo() + ": " + v.getPrecio()));
    }
}
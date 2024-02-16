package org.example;

import org.example.vehiculos.Garage;
import org.example.vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // equipo 5
    // 2 sorted es igual then compairing

    List<Vehiculo> lista = List.of(
        new Vehiculo("Ford", "Fiesta", 1000, 2010),
        new Vehiculo("Ford", "Focus", 1200, 2015),
        new Vehiculo("Ford", "Explorer", 2500, 2000),
        new Vehiculo("Fiat", "Uno", 500, 1997),
        new Vehiculo("Fiat", "Cronos", 1000, 2018),
        new Vehiculo("Fiat", "Torino", 1250, 1965),
        new Vehiculo("Chevrolet", "Aveo", 1250, 2020),
        new Vehiculo("Chevrolet", "Spin", 2500, 2021),
        new Vehiculo("Toyota", "Corola", 1200, 2022),
        new Vehiculo("Toyota", "Fortuner", 3000, 2018),
        new Vehiculo("Renault", "Logan", 950, 2009)
    );

    Garage garage = new Garage(1, lista);

    System.out.println("-----------------");
    System.out.println("Vehiculos ordenados por precio");
    System.out.println(garage.ordernarVehiculosPrecio());
    System.out.println("\n-----------------");
    System.out.println("Vehiculos ordenados por marca y precio");
    System.out.println(garage.ordernarVehiculosMarcaPrecio());
    System.out.println("\n-----------------");
    System.out.println("Vehiculos menores a 1000");
    System.out.println(garage.ordernarVehiculosMenor1000());
    System.out.println("\n-----------------");
    System.out.println("Vehiculos mayores o iguales a 1000 por precio");
    System.out.println(garage.ordernarVehiculosMayorIgual1000());
    System.out.println("\n-----------------");
    System.out.println("Promedio del costo de los vehiculos");
    System.out.println(garage.promedioTotal());
    System.out.println("\n-----------------");
    System.out.println("Descuento para años anteriores o iguales a 2000");
    System.out.println(garage.aplicarDescuento(2000, 20));
  }
}

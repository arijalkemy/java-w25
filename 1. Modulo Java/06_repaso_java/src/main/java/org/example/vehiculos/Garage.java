package org.example.vehiculos;

import java.util.*;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getvehiculos() {
        return this.vehiculos;
    }

    public void setvehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> ordernarVehiculosPrecio(){
        return this.vehiculos.stream()
                                    .sorted(Comparator.comparing(Vehiculo::getPrecio))
                                    .toList();
    }
    public List<Vehiculo> ordernarVehiculosMarcaPrecio(){
        return this.ordernarVehiculosPrecio().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .toList();
        // return this.vehiculos.stream()
        //         .sorted(Comparator.comparing(Vehiculo::getPrecio))
        //         .sorted(Comparator.comparing(Vehiculo::getMarca))
        //         .toList();
    }

    public List<Vehiculo> ordernarVehiculosMenor1000(){
        return this.vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPrecio() < 1000)
                .toList();
    }

    public List<Vehiculo> ordernarVehiculosMayorIgual1000(){
        return this.vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPrecio() >= 1000)
                .toList();
    }

    public double promedioTotal(){
        return this.vehiculos.stream()
                                    .mapToInt(vehiculo -> vehiculo.getPrecio())
                                    .average()
                                    .orElse(0);
    }

    public List<Vehiculo> aplicarDescuento(int anio, int descuento){
        return this.vehiculos.stream()
                .filter(vehiculo -> vehiculo.getAnio() <= anio)
                .map(v -> v.aplicarDescuento(descuento))
                .toList();
    }
}

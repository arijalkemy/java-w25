package org.example.vehiculos;

import java.util.*;

public class Garage {
    private int id;
    private List<Vehiculo> listaDeVehiculos;

    public Garage(int id, List<Vehiculo> listaDeVehiculos) {
        this.id = id;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public List<Vehiculo> ordernarVehiculosPrecio(){
        return this.listaDeVehiculos.stream()
                                    .sorted(Comparator.comparing(Vehiculo::getCosto))
                                    .toList();
    }
    public List<Vehiculo> ordernarVehiculosMarcaPrecio(){
        return this.listaDeVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .toList();
    }

    public List<Vehiculo> ordernarVehiculosMenor1000(){
        return this.listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .toList();
    }

    public List<Vehiculo> ordernarVehiculosMayorIgual1000(){
        return this.listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();
    }

    public double promedioTotal(){
        return this.listaDeVehiculos.stream()
                                    .mapToInt(vehiculo -> vehiculo.getCosto())
                                    .average()
                                    .orElse(0);
    }

    public List<Vehiculo> aplicarDescuento(int anio, int descuento){
        return this.listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.getAnio() <= anio)
                .map(v -> v.aplicarDescuento(descuento))
                .toList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return this.listaDeVehiculos;
    }

    public void setListaDeVehiculos(ArrayList<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}

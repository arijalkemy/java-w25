package org.example;

import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> lVehiculos;



    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro,String patente){
        Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        this.lVehiculos.add(auto);
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void eliminarVehiculo(String unaPatente){

    }

    public void eliminarVehiculoConPatente(String unaPatente){

    }
}

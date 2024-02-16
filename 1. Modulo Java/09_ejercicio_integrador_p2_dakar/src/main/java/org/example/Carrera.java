package org.example;

import java.util.List;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Carrera {
    double distancia;
    double premioEnDolares;
    String nombre;
    int cantidadVehiculosPermitidos;
    List<Vehiculo> vehiculos;

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro,String patente){
        Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        this.vehiculos.add(auto);
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        Vehiculo moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void eliminarVehiculo(String unaPatente){

    }

    public void eliminarVehiculoConPatente(String unaPatente){

    }
}

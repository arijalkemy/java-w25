package org.example;

import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private double cantidadDeVehivulosPermitidos;
    private List<Vehiculo> listaVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, double cantidadDeVehivulosPermitidos, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehivulosPermitidos = cantidadDeVehivulosPermitidos;
        this.listaVehiculos = listaVehiculos;
    }
}

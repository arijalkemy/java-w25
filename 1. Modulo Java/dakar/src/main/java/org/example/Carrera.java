package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera{
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    SocorristaAuto socorristaAuto;
    SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos
            , SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente){
        if(cantidadDeVehiculosPermitidos > 0)
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad,double aceleracion, int anguloDeGiro, String patente){
        if(cantidadDeVehiculosPermitidos > 0)
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));

    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        vehiculos.stream()
                .filter( v -> v.getPatente().equals(unaPatente))
                .findFirst().ifPresent( v -> vehiculos.remove(v));
    }

    public Vehiculo obtenerGanador(){
        return vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularMaximoValor))
                .get();
    }

    public void socorrerAuto(String patente){
       vehiculos.stream()
               .filter( v -> v.getPatente().equals(patente))
               .findFirst()
               .ifPresent(v -> socorristaAuto.socorrer(v));
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo = vehiculos.stream()
                .filter( v -> v.getPatente().equals(patente))
                .findFirst()
                .get();
        socorristaMoto.socorrer(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}

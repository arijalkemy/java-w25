package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Carrera() {
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro,String patente){
        if(cantidadDeVehiculosPermitidos < vehiculos.size()){
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro,String patente){
        if(cantidadDeVehiculosPermitidos < vehiculos.size()){
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
       Optional<Vehiculo> optionalVehiculo =  vehiculos.stream().filter
               (v -> v.getPatente().equalsIgnoreCase(patente)).findFirst();
        optionalVehiculo.ifPresent(this::eliminarVehiculo);
    }

    public Vehiculo determinarGanador(){
       // Velocidad * 0.5 Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        Vehiculo ganador = vehiculos.get(0);
        double max = 0.0;
        for (Vehiculo v : vehiculos){
            if(v instanceof Vehiculo || v instanceof Moto){ // Los socorristas no pueden ser ganadores
                double calculation = v.getVelocidad() * 0.5 * v.getAceleracion()
                        / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
                if(max < calculation) {
                    max = calculation;
                    ganador = v;
                }
            }

        }
        return ganador;
    }

    public void socorrerAuto(String patente){
        for (Vehiculo v : vehiculos){
            if (v instanceof SocorristaVehiculo) ((SocorristaVehiculo) v).socorrerVehiculo(patente);
        }
    }

    public void socorrerMoto(String patente){
        for (Vehiculo v : vehiculos){
            if (v instanceof SocorristaMoto) ((SocorristaMoto) v).socorrerMoto(patente);
        }
    }


}

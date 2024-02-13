package org.example;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermi;
    private List<Vehiculo> listaDeVehiculos = new ArrayList<>();

    public Carrera() {
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermi) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermi = cantidadDeVehiculosPermi;
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

    public int getCantidadDeVehiculosPermi() {
        return cantidadDeVehiculosPermi;
    }

    public void setCantidadDeVehiculosPermi(int cantidadDeVehiculosPermi) {
        this.cantidadDeVehiculosPermi = cantidadDeVehiculosPermi;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaVehiculo(Vehiculo vehiculo){
        String cant = (  listaDeVehiculos.toArray().length < cantidadDeVehiculosPermi) ?
                "Se agrego vehiculo "  + this.listaDeVehiculos.add(vehiculo): "No se agrego";

        System.out.println(cant);
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculo(String patente){
        Vehiculo vehiculoAEliminar= listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().orElse(null);        
        listaDeVehiculos.remove(vehiculoAEliminar);
    }



    public void imprimirLista(){
        listaDeVehiculos.forEach(System.out::println);
    }


}

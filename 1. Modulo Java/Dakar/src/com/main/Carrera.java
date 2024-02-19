package com.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantVehiculoPermitido;
    private List<Vehiculo> listVehiculos;

    public Carrera(double distancia, double premioDolares, String nombre, int cantVehiculoPermitido) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantVehiculoPermitido = cantVehiculoPermitido;
        this.listVehiculos = new ArrayList<>();
    }
    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if (this.listVehiculos.size() < this.cantVehiculoPermitido) {
            Vehiculo carro = new Auto(velocidad, aceleracion, anguloGiro, patente);
            this.listVehiculos.add(carro);
            System.out.println("Se agregó un auto a la carrera.");
        } else {
            System.out.println("No se puede agregar más vehículos, se ha alcanzado el límite permitido.");
        }
    }

    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloGiro,String patente){
        if (listVehiculos.size() < this.cantVehiculoPermitido){
            Vehiculo moto = new Moto(velocidad,aceleracion,anguloGiro,patente);
            this.listVehiculos.add(moto);
            System.out.println("Se agregó una moto a la carrera.");
        } else {
            System.out.println("No se puede agregar más vehículos, se ha alcanzado el límite permitido.");
        }
    }

    public void eliminarVehiculo(Vehiculo vh){
        Iterator<Vehiculo> iterator = listVehiculos.iterator();
        while (iterator.hasNext()) {
            Vehiculo vehiculo = iterator.next();
            if (vehiculo==vh) {
                iterator.remove();
                System.out.println("Se eliminó correctamente al vehículo");
                return;
            }
        }
        System.out.println("El vehículo no se encuentra inscripto.");
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        Iterator<Vehiculo> iterator = listVehiculos.iterator();
        while (iterator.hasNext()) {
            Vehiculo vehiculo = iterator.next();
            if (vehiculo.getPatente().equals(unaPatente)) {
                iterator.remove();
                System.out.println("Se eliminó el vehículo con la patente " + unaPatente + " de la carrera.");
                return;
            }
        }
        System.out.println("No se encontró ningún vehículo con la patente " + unaPatente + ".");
    }

    public Vehiculo obtenerGanador(){
        if (listVehiculos.isEmpty()) {
            System.out.println("No hay vehículos en la carrera.");
            return null;
        }
        else {
            Vehiculo vehiculoGanador= listVehiculos.get(0);
            double maxValor=0;
            for (Vehiculo auto: listVehiculos){
                double calculoValor = (auto.getVelocidad()*(auto.getAceleración()/2))/
                        (auto.getAnguloDeGiro()*(auto.getPeso()-(auto.getRuedas()*100)));
                if (calculoValor>maxValor){
                    maxValor= calculoValor;
                    vehiculoGanador = auto;
                }
            }
            return vehiculoGanador;
        }
    }
    public void socorrerAuto(String patente){
        System.out.println("Socorriendo auto:" + patente);
    }

    public void socorrerMoto(String patente){
        System.out.println("Socorriendo moto:" + patente);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(double premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVehiculoPermitido() {
        return cantVehiculoPermitido;
    }

    public void setCantVehiculoPermitido(int cantVehiculoPermitido) {
        this.cantVehiculoPermitido = cantVehiculoPermitido;
    }

    public List<Vehiculo> getListVehiculos() {
        return listVehiculos;
    }

    public void setListVehiculos(List<Vehiculo> listVehiculos) {
        this.listVehiculos = listVehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioDolares=" + premioDolares +
                ", nombre='" + nombre + '\'' +
                ", cantVehiculoPermitido=" + cantVehiculoPermitido +
                ", listVehiculos=" + listVehiculos +
                '}';
    }
}

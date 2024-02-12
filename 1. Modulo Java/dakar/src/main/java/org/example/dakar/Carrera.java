package org.example.dakar;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premio;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private final ArrayList<Vehiculo> listaVehiculos;
    private SocorristaMoto socorristaMoto;
    private SocorristaCarro socorristaCarro;

    public Carrera(double distancia, double premio, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.socorristaMoto = new SocorristaMoto();
        this.socorristaCarro = new SocorristaCarro();
    }
    public void socorrerMoto(String patente){
        listaVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().ifPresent(vehiculo -> socorristaMoto.socorrer((Moto) vehiculo));
    }
    public void socorrerCarro(String patente){
        listaVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().ifPresent(vehiculo -> socorristaCarro.socorrer((Carro) vehiculo));
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaVehiculos.size() < cantidadDeVehiculosPermitidos){
            Carro carro = new Carro(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(carro);
        } else {
            System.out.println("No hay cupo en la carrera");
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaVehiculos.size() < cantidadDeVehiculosPermitidos){
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(moto);
        } else {
            System.out.println("No hay cupo en la carrera");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaVehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoPorPatente(String patente) {
        /*
         for(Vehiculo vehiculo : listaVehiculos) {
                    if(vehiculo.getPatente().equals(patente)) {
                        listaVehiculos.remove(vehiculo);
                    }
                }
        * */
        listaVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }
    public Vehiculo definirGanador(){
        double formulaGanador = 0;
        Vehiculo vehiculoGanador = null;
        for(Vehiculo vehiculo : listaVehiculos) {
            double formulaActual = vehiculo.getVelocidad()*(0.5)*vehiculo.getAceleracion()/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
            if(formulaActual > formulaGanador) {
                formulaGanador = formulaActual;
                vehiculoGanador = vehiculo;
            }
        }
        assert vehiculoGanador != null;
        System.out.println("El vehículo ganador es: "+ vehiculoGanador);
        return vehiculoGanador;
    }
    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
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

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

}

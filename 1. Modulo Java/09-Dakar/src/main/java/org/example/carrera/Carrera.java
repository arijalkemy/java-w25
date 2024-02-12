package org.example.carrera;

import org.example.socorristas.SocorristaAuto;
import org.example.socorristas.SocorristaMoto;
import org.example.vehiculo.Auto;
import org.example.vehiculo.Moto;
import org.example.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private double distancia;

    private  double premioEnDolares;

    private String nombre;

    private int cantidadVehiculosPermitidos;

    private List<Vehiculo> listaVehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad,double aceleracion,double anguloDeGiro, String patente){

        if ( this.listaVehiculos.size()< this.cantidadVehiculosPermitidos){
            listaVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Auto registrado");
        }else {
            System.out.println("no hay cupo");
        }

    }

    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro, String patente){

        if ( this.listaVehiculos.size()< this.cantidadVehiculosPermitidos){
            listaVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Moto registrado");
        }else {
            System.out.println("no hay cupo");
        }

    }


    public Optional<Vehiculo> encontrarVehiculo(String patente){

        return this.listaVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().toLowerCase().equals(patente.toLowerCase())).findFirst();
    }

    public void socorrerAuto(String patente){

        if (encontrarVehiculo(patente).isPresent()){
            this.socorristaAuto.socorrerAuto(encontrarVehiculo(patente).get());
        }else {
            System.out.println("No se encontro vehiculo");
        }


    }

    public void socorrerMoto(String patente){

        if (encontrarVehiculo(patente).isPresent()){
            this.socorristaAuto.socorrerAuto(encontrarVehiculo(patente).get());
        }else {
            System.out.println("No se encontro vehiculo");
        }

    }


    public void eliminarVehiculo(Vehiculo vehiculo){
        this.listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        Optional<Vehiculo> existe = this.listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().toLowerCase().equals(patente.toLowerCase()))
                .findFirst();

        if (existe.isPresent()){
            eliminarVehiculo(existe.get());
        }else{

            System.out.println("No se pudo eliminar");
        }


    }


    public Vehiculo definirGanador(){
        double calculoGanador = 0;
        Vehiculo ganador = null;
        for (Vehiculo vehiculo:this.listaVehiculos){
            double calculo = 0;
            calculo = (vehiculo.getVelocidad()*1/2*vehiculo.getAceleracion())/(vehiculo.getPeso()-vehiculo.getRuedas()*100);

            if (calculo> calculoGanador){
                calculo = calculoGanador;
                ganador =vehiculo;
            }
        }

        return ganador;

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

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}

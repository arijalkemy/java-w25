package org.clase06_02_24.ejercicio_dakar;

import java.util.List;

public class Carrera {
    private int distancia;
    private int premio;
    private String nombre;
    private int cantVehiculos;
    private List<Vehiculo> vehiculos;

    public void darDeAltaAuto(int velocidad, int aceleracion,double anguloDeGiro, String patente) {
        if(vehiculos.size()<cantVehiculos){
            vehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
        }else {
            System.out.println("no hay cupo capo");
        }
    }

    public void darDeAltaMoto(int velocidad,int  aceleracion, double anguloDeGiro,String patente) {
        if(vehiculos.size()<cantVehiculos){
            vehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        }else {
            System.out.println("no hay cupo capo");
        }
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        try{
            vehiculos.remove(vehiculo);}
        catch (Exception e){
            throw new RuntimeException("el vehiculo no existe");
        }
    }public void eliminarVehiculoPatente(String patente){
        try{
            vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equalsIgnoreCase(patente));}
        catch (Exception e){
            throw new RuntimeException("el vehiculo no existe");
        }
    }
    public Vehiculo obtenerGanador(){
        //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        Vehiculo vehiculoganador = null;
        double puntaje = 0;
        for(Vehiculo vehiculo: vehiculos){
            if (calcularPuntaje(vehiculo)>puntaje){
                vehiculoganador = vehiculo;
                puntaje=calcularPuntaje(vehiculo);
            }
        }
        return vehiculoganador;
    }
    public double calcularPuntaje(Vehiculo v){
        return v.getVelocidad()*((double) v.getAceleracion() /2)/(v.getAnguloGiro()*(v.getPeso()-v.getCantRuedas()*100));
    }



    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVehiculos() {
        return cantVehiculos;
    }

    public void setCantVehiculos(int cantVehiculos) {
        this.cantVehiculos = cantVehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Carrera(int distancia, int premio, String nombre, int cantVehiculos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantVehiculos = cantVehiculos;
        this.vehiculos = vehiculos;
    }
}

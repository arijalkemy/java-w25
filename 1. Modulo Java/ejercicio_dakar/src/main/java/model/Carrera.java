package model;

import interfaces.Socorrista;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia, premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private Socorrista socorristaAuto, socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto (double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (this.vehiculos.size() > this.cantidadDeVehiculosPermitidos)
            this.vehiculos.add(new Auto(velocidad, aceleracion,anguloDeGiro,patente));
        else
            System.out.println("No se puede agregar el auto. No quedan cupos disponibles en la carrera.");
    }
    public void darDeAltaMoto (double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (this.vehiculos.size() > this.cantidadDeVehiculosPermitidos)
            this.vehiculos.add(new Moto(velocidad, aceleracion,anguloDeGiro,patente));
        else
            System.out.println("No se puede agregar la moto. No quedan cupos disponibles en la carrera.");
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }
    public void calcularGanador(){
        Optional<Vehiculo> vehiculoGanador = vehiculos.stream()
                .max(Comparator.comparingDouble(v -> v.getVelocidad() * 0.5 * v.getAceleracion() /
                        (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100))));

        if (vehiculoGanador.isPresent()) {
            Vehiculo ganador = vehiculoGanador.get();
            System.out.println("El ganador es: " + ganador);
        } else {
            System.out.println("No hay vehículos en el garaje.");
        }
    }
    public void socorrerAuto(String patente){
        Vehiculo auto = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst().orElse(null);
        socorristaMoto.socorrer(auto);
    };
    public void socorrerMoto(String patente){
        Vehiculo moto = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst().orElse(null);
        socorristaMoto.socorrer(moto);
    };
}

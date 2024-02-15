package org.example.model;

public class SocorristaVehiculo extends Vehiculo{
    public SocorristaVehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrerVehiculo(String patente){
        System.out.println("Socorriendo vehiculo " + patente);
    }
}

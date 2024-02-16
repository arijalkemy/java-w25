package org.example;

public abstract class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloGiro;
    private String patente;

    public Vehiculo() {
    }

    public Vehiculo(double velocidad, double aceleracion, double anguloGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
    }
}

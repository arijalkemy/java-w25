package org.example;

public class Moto extends Vehiculo{
    private static int ruedas = 2;
    private static int peso = 300;
    public Moto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
    }
}

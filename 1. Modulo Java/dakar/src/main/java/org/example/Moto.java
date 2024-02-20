package org.example;

public class Moto extends Vehiculo{
    private static final double PESO = 300;
    private static final int CANTIDAD_RUEDAS = 2;

    public Moto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, CANTIDAD_RUEDAS);
    }
}

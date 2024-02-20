package org.example;

public class Auto extends Vehiculo{

    private static final double PESO = 1000;
    private static final int CANTIDAD_RUEDAS = 4;

    public Auto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, CANTIDAD_RUEDAS);
    }

}

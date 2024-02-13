package model;

public class Auto extends Vehiculo {
    private final static double peso = 1000;
    private final static int ruedas = 4;
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, peso, ruedas, patente);
    }
}

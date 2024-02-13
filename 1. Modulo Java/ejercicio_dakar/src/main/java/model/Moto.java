package model;

public class Moto extends Vehiculo {
    private final static double peso = 300;
    private final static int ruedas = 2;
    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, peso, ruedas, patente);
    }
}

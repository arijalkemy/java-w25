package org.example;

public class Autos extends Vehiculo {

    double peso;
    int ruedas;

    public Autos(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 1000;
        this.ruedas = 4;

    }

    @Override
    public double getPeso() {
        return peso;
    }

    @Override
    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int getRuedas() {
        return ruedas;
    }

    @Override
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Autos{" + getVelocidad() +
                "peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}

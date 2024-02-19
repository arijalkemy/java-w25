package org.example.dakar;

public class Carro extends Vehiculo {
    protected Carro(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }
}

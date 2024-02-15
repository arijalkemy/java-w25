package org.example.model;

public class SocorristaMoto extends Vehiculo{
    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrerMoto(String patente){
        System.out.println("Socorriendo moto : " + patente);
    }
}

package com.main;

public class SocorristaMoto extends Moto{
    public SocorristaMoto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
    }
    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo moto:" + unaMoto.getPatente());
    }
}

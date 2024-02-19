package com.main;

public class SocorristaAuto extends Auto{
    public SocorristaAuto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
    }
    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo auto:" + unAuto.getPatente());
    }
}

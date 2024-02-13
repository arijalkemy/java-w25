package model;

import interfaces.Socorrista;

public class SocorristaAuto implements Socorrista {

    @Override
    public void socorrer(Vehiculo unAuto) {
        System.out.println("Socorriendo auto...");
        System.out.println(unAuto.getPatente());
    }
}

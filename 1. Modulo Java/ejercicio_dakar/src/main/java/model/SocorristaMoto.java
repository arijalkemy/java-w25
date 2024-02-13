package model;

import interfaces.Socorrista;

public class SocorristaMoto implements Socorrista {
    @Override
    public void socorrer(Vehiculo unaMoto) {
        System.out.println("Socorriendo moto...");
        System.out.println(unaMoto.getPatente());
    }
}

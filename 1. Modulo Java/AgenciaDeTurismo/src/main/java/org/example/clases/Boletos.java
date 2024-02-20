package org.example.clases;

public class Boletos extends Paquete{
    public Boletos() {
    }

    public Boletos(int id, double costo) {
        super(id, costo);
    }

    @Override
    public String toString() {
        return "BoletoViaje {" +
                "id = '" + this.getId() + '\'' +
                ", Costo = " + this.getCosto() + '\'' +
                '}';
    }
}

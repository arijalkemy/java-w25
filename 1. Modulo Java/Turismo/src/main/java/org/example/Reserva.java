package org.example;

public abstract class Reserva {

    private double importe;
    protected String nombre;

    public Reserva(double importe) {
        this.importe = importe;
    }

    public double getImporte() {
        return this.importe;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return  this.nombre +
                " - Precio Reserva: " + this.importe;
    }
}

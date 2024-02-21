package org.example;

public abstract class Reserva {

    protected double importe;
    protected String nombre;

    public Reserva(double importe) {
        this.importe = importe;
    }

    public void aplicarDescuento(double descuento) {
        this.importe *= 1 - descuento/100;
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

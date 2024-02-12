package org.example.model;

public class ReservaBase implements IReserva {
    private Double precio;
    private String caracteristicas;

    public ReservaBase() {
        this.precio = 0.0;
        this.caracteristicas = "";
    }


    @Override
    public Double getPrecio() {
        return this.precio;
    }

    @Override
    public String getCaracteristicas() {
        return this.caracteristicas;
    }
}

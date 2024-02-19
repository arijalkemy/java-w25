package com.main.Servicios;

public abstract class Reservas {
    protected double precio;
    protected double cantidad;
    protected double total;

    public Reservas(double precio, double cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = totalReserva();
    }
    public double totalReserva() {
        double totalPagar=this.precio*this.cantidad;
        return totalPagar;
    }

    public double getTotal() {
        return total;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public abstract void realizarReserva();

}

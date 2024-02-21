package org.example;

public class Producto {
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    private String nombre;
    private double precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double calcular(int cantidadDeProductos){
        return this.precio * cantidadDeProductos;

    }
    @Override
    public String toString() {
        return "Producto{" +
                "nonbre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

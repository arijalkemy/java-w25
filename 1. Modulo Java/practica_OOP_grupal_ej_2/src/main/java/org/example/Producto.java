package org.example;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "NOMBRE PROD.: " + this.nombre
                + "\nPRECIO PROD.: $" + this.precio;
    }

    public double calcular(int cantidadDeProductos){
        return precio * cantidadDeProductos;
    }


}

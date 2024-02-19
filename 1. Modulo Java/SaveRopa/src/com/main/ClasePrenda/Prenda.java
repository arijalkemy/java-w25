package com.main.ClasePrenda;

public class Prenda {
    protected String nombre;
    protected String marca;
    protected String modelo;

    public Prenda(String nombre, String marca, String modelo) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "\nNombre='" + nombre + ',' +
                "Marca='" + marca + ',' +
                "Modelo='" + modelo;
    }
}

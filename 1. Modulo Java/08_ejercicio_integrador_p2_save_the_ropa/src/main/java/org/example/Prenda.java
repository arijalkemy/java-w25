package org.example;


public class Prenda {
    // Crear la clase Prenda que contenga los atributos marca y modelo.
    private String marca;
    private String modelo;

    public Prenda() {
    }

    public Prenda(String marca) {
        this.marca = marca;
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
        return "{marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + '}';
    }
}

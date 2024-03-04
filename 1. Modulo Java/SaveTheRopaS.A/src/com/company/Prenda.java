package com.company;

public class Prenda {
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

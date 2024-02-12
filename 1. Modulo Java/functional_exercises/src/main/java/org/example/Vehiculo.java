package org.example;

public class Vehiculo {
    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo(String modelo, String marca, double costo){
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString(){
        return "Marca: " + marca + "\n" + "Modelo: " + modelo + "\n" + "Costo: " + costo;
    }

}

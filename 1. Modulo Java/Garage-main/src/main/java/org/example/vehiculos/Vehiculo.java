package org.example.vehiculos;

public class Vehiculo {
    private String modelo;
    private String marca;
    private int costo;

    private int anio;

    public Vehiculo(String marca, String modelo, int costo, int anio){
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
        this.anio =  anio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCosto() {
        return this.costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getAnio() {
        return this.anio;
    }

    public Vehiculo aplicarDescuento(int descuento){
        return new Vehiculo(this.marca, this.modelo, this.costo - descuento, this.anio);
    }

    @Override
    public String toString(){
        return this.marca + " " + this.modelo + " ($" + this.costo + ")";
    }
}

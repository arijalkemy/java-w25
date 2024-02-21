package main.java.com.bootcamp;

public class Vehiculo {
    private String marca;
    private String modelo;
    private Double costo;

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

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }

    public Vehiculo(String marca, String modelo, Double costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }
}
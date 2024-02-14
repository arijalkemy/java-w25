package org.clase06_02_24.ejercicio_dakar;

public class Vehiculo {
    private int velocidad;
    private int aceleracion;
    private double anguloGiro;
    private String patente;
    private int peso;
    private int cantRuedas;

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloGiro=" + anguloGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", cantRuedas=" + cantRuedas +
                '}';
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(int aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloGiro() {
        return anguloGiro;
    }

    public void setAnguloGiro(double anguloGiro) {
        this.anguloGiro = anguloGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCantRuedas() {
        return cantRuedas;
    }

    public void setCantRuedas(int cantRuedas) {
        this.cantRuedas = cantRuedas;
    }

    public Vehiculo(int velocidad, int aceleracion, double anguloGiro, String patente, int peso, int cantRuedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.cantRuedas = cantRuedas;
    }
}

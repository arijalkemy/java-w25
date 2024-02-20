package org.example;

public abstract class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private int anguloDeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo(double velocidad, double aceleracion, int anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double calcularMaximoValor(){
        return ( velocidad * 1/2 * aceleracion )
                / ( anguloDeGiro * ( peso - ( ruedas * 100 )));
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}

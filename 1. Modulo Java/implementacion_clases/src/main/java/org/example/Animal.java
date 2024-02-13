package org.example;

public class Animal {
    private String especie;

    public Animal() {
    }

    public Animal(String especie) {
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void mostrarEspecie() {
        System.out.println("Soy un animal y mi especie es: " + this.especie);
    }

    public void hacerSonido() {
        System.out.println("Haciendo sonido.");
    }
}

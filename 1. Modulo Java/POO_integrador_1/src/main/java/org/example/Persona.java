package org.example;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double IMC = peso / (java.lang.Math.pow(altura, 2));
        if (IMC < 20) {
            return -1;
        } else if (IMC <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", DNI: " + dni + ", Peso: " + peso + ", Altura: " + altura;
    }
}

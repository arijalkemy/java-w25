package org.example;

public class Persona {

    private String nombre;
    private int edad;
    private int dni;
    private double altura;
    private double peso;

    public Persona() {
    }

    public Persona(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, int dni, double altura, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public int calcularIMC() {
        if (altura <= 0 || peso <= 0) {
            throw new IllegalArgumentException("El peso y la altura deben ser mayores a 0");
        }

        double imc = peso / (Math.pow(altura, 2));

        if (imc < 18.5) {
            return -1; // bajo peso
        } else if (imc >= 18.5 && imc <= 24.9) {
            return 0; // peso normal
        } else if (imc >= 25 && imc <= 29.9) {
            return 1; // sobrepeso
        }

        return 2; // obeso
    }

    public boolean esMayorDeEdad(){
        if (edad>18) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni=" + dni +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}




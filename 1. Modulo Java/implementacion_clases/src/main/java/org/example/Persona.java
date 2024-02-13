package org.example;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularImc() {
        double imc = this.peso / Math.pow(this.altura, 2);

        if (imc >= 25) {
            return 1;
        } else if (imc <= 20) {
            return -1;
        }
        return 0;
    }

    public String convertirImc() {
        if (this.calcularImc() == 0) {
            return "Peso saludable.";
        } else if (this.calcularImc() == 1) {
            return "Sobrepeso.";
        }
        return "Bajo peso.";
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String convertirMayorDeEdad() {
        if (this.esMayorDeEdad()) {
            return "Sí. (" + this.edad + " años)";
        }
        return "No (" + this.edad + " años).";
    }

    @Override
    public String toString() {

        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDni: " + dni + "\nPeso: " + peso + "\nAltura: " + altura
                + "\nImc: " + this.convertirImc() + "\nEs mayor de edad: " + this.convertirMayorDeEdad();
    }
}

package org.example;

public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;


    public Persona() {
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC(){

        double imc = this.peso / (this.altura * this.altura);
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }

    }


    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }


    @Override
    public String toString() {
        return
                "Nombre: " + nombre + '\n' +
                "Edad: " + edad + '\n' +
                "DNI: " + dni  + '\n' +
                "Peso: " + peso + '\n' +
                "Altura: " + altura;
    }
}

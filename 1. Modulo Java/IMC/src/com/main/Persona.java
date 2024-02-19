package com.main;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    // Constructor sin parámetros
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.peso = 0;
        this.altura = 0;
    }
    // Constructor que recibe nombre, edad y dni como parámetros
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    // Constructor que recibe nombre y edad parámetros
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    // Constructor que recibe todos los atributos como parámetros
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
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

    public double calcularIMC(){
        if (altura>0){
            double resultado= this.peso/(Math.pow(this.altura, 2));
            if (resultado<20){
                return -1;
            }else{
                if (resultado>=20 || resultado<=25) {
                    return 0;
                }else{
                    return 1;
                }
            }
        }
        else{
            return -2;
        }

    }

    public boolean esMayorDeEdad(){
        if (this.edad>=18){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}

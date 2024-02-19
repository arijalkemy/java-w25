package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;


    public Persona(){

    };

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

    public int calcularIMC(){
        double mc;
        mc = this.peso / Math.pow(this.altura , 2);
        if (mc < 20){
            return -1;
        } else if (mc >= 20 && mc <= 25) {
            return 0;
        }
        else{
            return 1;
        }
    }

    public boolean mayorDeEdad(){
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona " +
                " de nombre " + nombre +
                ", tiene una edad de " + edad +
                " años, con un dni " + dni +
                ", y su peso es de " + peso +
                " kilos, y altura " + altura +
                " metros";
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
}

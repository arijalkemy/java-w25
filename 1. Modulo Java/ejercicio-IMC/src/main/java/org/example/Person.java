package org.example;

public class Person {

    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;

    public Person ( ){

    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int calculateIMC() {
        double num = this.weight;
        double denom = Math.pow(this.height, 2);
        double imc = num / denom;
        if(imc < 20) {
            return -1;
        }
        if(imc >= 20 && imc <= 25) {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad() {
        return this.age >= 18;
    }

    public String toString() {
        return "Persona{" +
                "nombre='" + name + '\'' +
                ", edad=" + age +
                ", dni='" + dni + '\'' +
                ", peso=" + weight +
                ", altura=" + height +
                '}';
    }
}

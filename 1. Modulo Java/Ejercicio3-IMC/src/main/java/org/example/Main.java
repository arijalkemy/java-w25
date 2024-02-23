package org.example;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Richard", 20,"1234");
        Persona persona3 = new Persona("Melissa", 36, "5678", 58.7,1.54);

        if (persona3.calcularIMC() == -1) {
            System.out.println("Tienes bajo peso");
        }
        if (persona3.calcularIMC() == 0){
            System.out.println("Tienes un peso saludable");
        }
        else {
            System.out.println("Tienes sobrepeso");
        }

        if (persona3.esMayorDeEdad()) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }

        System.out.println(persona3.toString());
    }
}
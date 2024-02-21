package org.example;

public class Main {
    public static void main(String[] args) {

        Persona persona0 = new Persona();//sin parametros
        Persona persona1 = new Persona("Diego", 29, "38321311");
        Persona persona2 = new Persona("Rocio", 25, "42500200", 45.20, 1.64);//persona con todos los parametros
        // Persona persona3 = new Persona("Richard", 37);//solo nombre y edad

        //6. Calcular el IMC de la persona con todos los parametros
        System.out.println(persona2);

        System.out.println("Su IMC es: ");
        switch(persona2.calcularIMC()){
            case -1 -> System.out.println("Bajo peso");
            case 0 -> System.out.println("Peso saludable");
            default -> System.out.println("Sobrepeso");
        }
    }
}
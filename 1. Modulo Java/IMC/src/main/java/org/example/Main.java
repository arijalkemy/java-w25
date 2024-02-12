package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona personaBase = new Persona("Ana", 19, "87654321B");

        Scanner tecla = new Scanner(System.in);

        String nombre = tecla.nextLine();
        int edad = tecla.nextInt();
        String dni = tecla.nextLine();
        double peso = tecla.nextDouble();
        double altura = tecla.nextDouble();

        Persona personaCompleta = new Persona(nombre, edad, dni, peso, altura);

        boolean mayorEdad = personaCompleta.esMayorDeEdad();
        int calculoIMC = personaCompleta.calcularIMC();

        System.out.printf("La persona con los datos: "+personaCompleta.toString()+" "+resultadoIMC(calculoIMC)+resultadoEdad(personaCompleta.esMayorDeEdad()));
    }

    public static String resultadoIMC(int IMC){
        String result = "";

        switch (IMC){
            case -1 -> result += "tiene bajo peso";
            case 0 -> result += "tiene peso saludable";
            case 1 -> result += "tiene sobrepeso";
            default -> result += "No se puede calcular el resultado";
        }
        return result;
    }

    public static String resultadoEdad(boolean esMayorEdad){
        return esMayorEdad ? " y es mayor de edad." : " y es menor de edad.";
    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        Persona vacio = new Persona();
        Persona parcial = new Persona("Juan", 20, "12345678");
        Persona completo = new Persona("Pedro", "87654321", 30, 80, 1.80);
        
        switch (completo.calcularIMC()) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        if (completo.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("No es mayor de edad");
        }

        System.out.println(completo.toString());;;;
    }
}
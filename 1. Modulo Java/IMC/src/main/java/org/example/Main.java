package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Persona personaPorDefecto = new Persona();
//        Persona personaBasico = new Persona("luis", 22, 123456789);
//        Persona personaCompleta = new Persona("mario", 45, 12345678, 1.79, 85);


        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("luis", 22, 123456789, 1.73, 81));
        personas.add(new Persona("mario", 45, 12345678, 1.79, 85));

        for (Persona persona : personas) {
            try {
                int imcPersona = persona.calcularIMC();
                boolean mayorEdad = persona.esMayorDeEdad();

                switch (imcPersona) {
                    case -1:
                        System.out.println("Bajo peso");
                        break;
                    case 0:
                        System.out.println("Peso normal");
                        break;
                    case 1:
                        System.out.println("Sobrepeso");
                        break;
                    case 2:
                        System.out.println("Obeso");
                        break;
                    default:
                        System.out.println("Resultado inválido");
                        break;
                }

                System.out.println("IMC: " + imcPersona + " | ¿Es mayor de edad? " + mayorEdad);
                System.out.println(persona.toString());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
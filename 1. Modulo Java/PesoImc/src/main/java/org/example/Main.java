package org.example;

public class Main {
    public static void main(String[] args) {

        Persona personaVacia = new Persona();
        Persona personaConTresDatos = new Persona("pepito", 28, "39465758");
        Persona personaCompleta = new Persona("roberto", 23, "73646464", 78, 170);
       // Persona personaRota = new Persona("roberto", 22);

personaCompleta.esMayorDeEdad();
personaCompleta.imprimirDatosPersona();


    }


}
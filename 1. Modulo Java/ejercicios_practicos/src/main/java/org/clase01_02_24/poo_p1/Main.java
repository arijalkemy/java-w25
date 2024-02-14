package org.clase01_02_24.poo_p1;

public class Main {
    public static void main(String[] args) {

        Persona personaEmpty = new Persona();
        Persona personaLite = new Persona("Facundo",33,"33.333.333");
        Persona personaFull = new Persona("Jorge", 34, "23123123",75.0,1.75);

        //Persona personaError = new Persona("Facundo");

        System.out.println("El IMC de " + personaFull.nombre + " es " + personaFull.calcularIMC() + ". Tambien, podemos afirmar que " + (personaFull.esMayorDeEdad()? "es mayor de edad." : "es menor de edad."));
    }
}

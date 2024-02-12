package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Persona personaSinParametros = new Persona();
        Persona personaAlgunosParametros = new Persona("Juan",32,"2222");
        Persona personaTodosParametros = new Persona("Pepito",24,"990",82.4,1.82);

        switch (personaTodosParametros.calcularIMC()){
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
    }
}
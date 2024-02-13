package org.example;

import org.example.models.Persona;

public class Main {
    public static void main(String[] args) {
        //---------------------------------------------------------------------------|VARS|
        Persona andres = new Persona();
        Persona david = new Persona("Andres",24,"1999382838");
        Persona samantha = new Persona("Samantha", 45,"325222222",56.0,154.0);
        //Persona erroena = new Persona("Solo el nombre",43); Problema: can not resolve constructor
        //---------------------------------------------------------------------------|PROCESS|
        System.out.println("El usuario "+ samantha.toString() +" Tiene los soguientes indices");
        switch (samantha.calcularIMC()){
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
        }
        //---------------------------------------------------------------------------|OUT|
        if (samantha.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
    }
}
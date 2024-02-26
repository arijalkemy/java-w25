package org.example;

import java.sql.SQLOutput;

public class Main {
    public static String conversor(Persona persona){
        int result = persona.calcularIMC();
        if (result == -1){
            return "Bajo peso";
        } else if (result == 0) {
            return "Peso saludable";
        }else{
            return "Sobrepeso";
        }
    }
    public static String convertirEdad(Persona persona){
        if (persona.esMayorDeEdad()){
            return "Es mayor de edad";
        }
        return "Es menor de edad";
    }
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("juan", 18, "1293749349");
        Persona p3 = new Persona("Andres", 32, "923829384", 63.8, 1.8);
        System.out.println(Main.conversor(p3));
        System.out.println(Main.convertirEdad(p3));
        System.out.println(p3.toString());
    }
}
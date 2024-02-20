package org.example;

import org.example.models.Persona;

import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Jose",27,"31233212");
        Persona persona3 = new Persona("Pepe",31,"324412322",1.67,62.3);

        //No es posible declarar una persona si falta algun valor ya que no compila
        //Persona persona4 = new Persona("Martin",18);
        int imc = persona3.calcularIMC();
        if (imc == -1) {
            System.out.println(persona3.toString() +" Está por debajo del peso recomendado.");
        } else if (imc == 0) {
            System.out.println(persona3.toString() +"Se encuentra en el rango de peso saludable.");
        } else if (imc == 1) {
            System.out.println(persona3.toString() +"Está por encima del peso recomendado.");
        }

        if (persona3.esMayorDeEdad()) {
            System.out.println(persona3.toString() +"La persona es mayor de edad.");
        } else {
            System.out.println(persona3.toString() +"La persona es menor de edad.");
        }

    }
}
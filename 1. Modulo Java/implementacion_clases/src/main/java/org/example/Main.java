package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //--------------------------------------------------------------------------------------------------------------

        /*Libro l = new Libro("Winnie Pooh", "A. A. Milne", 56);
        System.out.println(l.toString());*/

        /*public class Automovil {

            String marca;
            String color;
            double kilometros;

            public Automovil() {

            }

            public Automovil(String marca, String color, double kilometros) {
                this.marca = marca;
                this.color = color;
                this.kilometros = kilometros;
            }

            public String mostrarMarcaYColor() {
                return "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
            }
        }*/

        //--------------------------------------------------------------------------------------------------------------

        /*try {
            FileInputStream fileInputStream = new FileInputStream("prueba.txt");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }*/

        //--------------------------------------------------------------------------------------------------------------

        /*try {
            int[] numeros = new int[5];
            numeros[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            String mensajeFinal = "Este es el último mensaje";
        }*/

        //--------------------------------------------------------------------------------------------------------------

        /*Persona personaSinParametros = new Persona();
        Persona personaParcial = new Persona("Nachuchi", 20, "45244598");
        Persona personaCompleta = new Persona("Nachuchi", 20, "45244598", 66.6, 1.80);

        if (personaCompleta.calcularImc() == 0) {
            System.out.println("Peso saludable");
        } else if (personaCompleta.calcularImc() == 1) {
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Bajo peso");
        }

        if (personaCompleta.esMayorDeEdad()) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }

        System.out.println(personaCompleta.toString());*/

        //--------------------------------------------------------------------------------------------------------------

        /*Animal perro = new Perro("Perro","Pancha Jr.");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Animal gato = new Gato("Gato","Cooper");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal = perro;
        animal.hacerSonido();
        animal.mostrarEspecie();*/

        //--------------------------------------------------------------------------------------------------------------


    }
}
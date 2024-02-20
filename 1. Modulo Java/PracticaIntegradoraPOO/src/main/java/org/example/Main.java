package org.example;
import src.main.java.org.example.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("daniela",26,"1020483263");
        Persona persona3 = new Persona("daniela",26,"1020483263",89.5,1.65);
        //Persona persona4 = new Persona("daniela",25); no es posible ya que se establecierin los constructores con parametros especificos

        System.out.println(persona3.toString());

        if (persona3.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        }
        else {
            System.out.println("Es menor de edad");
        }

        int imc = persona3.calcularIMC();
        if (imc == -1) {
            System.out.println("Bajo de peso");
        }
        else {
            if (imc == 0){
                System.out.println("Peso Saludable");
            }
            else{
                System.out.println("Sobrepeso");
            }
        }
    }
}
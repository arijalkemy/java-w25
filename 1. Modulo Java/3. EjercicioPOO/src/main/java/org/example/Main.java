package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona personaSinParametros = new Persona();
        Persona persona1 = new Persona("Franco",24, "123321123");
        Persona persona2 = new Persona("Martin", 21, "9878723", 87.5, 1.8);

        int mcP5 = persona2.calcularIMC();

        if (persona2.mayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("Es menor de edad");
        }

        System.out.println(persona2.toString());

        switch (mcP5){
            case -1 -> System.out.println(persona2.getNombre() + " tiene bajo peso");
            case 0 -> System.out.println(persona2.getNombre() + " tiene peso saludable");
            case 1 -> System.out.println(persona2.getNombre() + " tiene sobrepeso");
        }
        }
    }

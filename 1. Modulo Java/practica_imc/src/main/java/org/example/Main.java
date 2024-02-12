package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona personaSinParametros = new Persona();
        Persona persona3Parametros = new Persona("Franco",24, "123321123");
        Persona persona5Parametros = new Persona("Martin", 21, "9878723", 87.5, 1.8);

        int mcP5 = persona5Parametros.calcularMC();

        if (persona5Parametros.mayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("Es menor de edad");
        }

        System.out.println(persona5Parametros.toString());

        switch (mcP5){
            case -1 -> System.out.println(persona5Parametros.getNombre() + " tiene bajo peso");
            case 0 -> System.out.println(persona5Parametros.getNombre() + " tiene peso saludable");
            case 1 -> System.out.println(persona5Parametros.getNombre() + " tiene sobrepeso");
        }
        }
    }

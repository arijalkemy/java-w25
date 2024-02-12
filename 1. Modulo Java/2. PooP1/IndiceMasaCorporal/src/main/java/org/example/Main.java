package org.example;

import java.text.MessageFormat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void mostrarNivelPeso(Persona persona){
        int imc = persona.calcularIMC();
        String nivelPeso = "";
        switch (imc){
            case 1 -> nivelPeso = "Sobre Peso";
            case 0 -> nivelPeso = "Peso Saludable";
            case -1 -> nivelPeso = "Bajo Peso";
        }
        System.out.println(MessageFormat.format("{0} tiene un {1}", persona.nombre, nivelPeso));
    }

    public static void main(String[] args) {
        //--------------------EJERCICIO 4----------------------------
        //Creacion de una persona por constructor
       Persona personaVacia = new Persona();
       Persona persona = new Persona("Micheal", 18, "123");
       Persona personaCompleta = new Persona("William",29,"456",76.6, 1.78);
       //Creacion persona solo nombre y edad, no se puede :(
//        Persona personaNombre = new Persona("Steven",17);
        mostrarNivelPeso(personaCompleta);


    }
}
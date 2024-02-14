package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona("Martin", 28, "37830728", 98, 1.86);
        Persona p2 = new Persona("Ana", 25, "16211485");
        Persona p3 = new Persona();


        int imc = p1.calcularIMC();


        System.out.println(p1);

        if(p1.esMayorDeEdad()){
            System.out.println("Mayor de edad");
        }else{
            System.out.println("Menor de edad");
        }

        System.out.print("Índice de masa corporal (IMC): ");
        switch (imc){
            case -1:
                System.out.println("Bajo Peso");
                break;
            case 0:
                System.out.println("Peso Saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        Persona persona1=new Persona();
        Persona persona2=new Persona("Kimba",4,"42888888");
        Persona persona3=new Persona("Valentín",23,"42877000",75,1.81);

        int persona3IMC= persona3.calcularIMC();
        boolean persona3MayorDeEdad = persona3.esMayorDeEdad();

        if (persona3IMC==-1){
            System.out.println("Bajo Peso");
        } else if (persona3IMC==0){
            System.out.println("Peso Saludable");
        } else System.out.println("Sobrepeso");

        System.out.println(persona3);
    }
}
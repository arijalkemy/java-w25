package org.example;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Juan", 20, "123456789");
        Person person3 = new Person("Nicolás", 28, "987654321", 100 , 1.75);

        int imc = person3.cacularIMC(person3.weight, person3.height);

        switch (imc) {
            case -1:
                System.out.println("El IMC es: " + imc + ". Tiene bajo peso.");
                break;
            case 0:
                System.out.println("El IMC es: " + imc + ". Tiene un peso saludable.");
                break;
            case 1:
                System.out.println("El IMC es: " + imc + ". Tiene sobre peso.");
        }

        boolean mayorDeEdad = person3.esMayorDeEdad(person3.age);

        System.out.println(mayorDeEdad ? "Es mayor de edad." : "Es menor de edad.");
    }
}
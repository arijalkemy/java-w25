package org.example;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person();
        Person person2 = new Person("Juan", 17, "12345678", 50, 1.80);
        Person person3 = new Person("Pedro", 20, "12445");

        if(person2.calculateIMC()==-1){
            System.out.println("La persona está por debajo de su peso ideal");
        } else if(person2.calculateIMC()==0){
            System.out.println("La persona está en su peso ideal");
        } else {
            System.out.println("La persona está por encima de su peso ideal");
        }
        if(person2.isAdult()){
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona es menor de edad");
        }
        System.out.println(person2.toString());

    }
}
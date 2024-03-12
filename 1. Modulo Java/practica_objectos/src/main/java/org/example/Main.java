package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona persona0 = new Persona();
        Persona persona1 = new Persona("edgar", 23, "mwzw18");
        Persona persona2 = new Persona("edgar",28,"medz1892", 75.3, 170.2);

        System.out.println("Person data = " + persona2.toString());
        System.out.println("Person is older = " + persona2.isOlder());

        switch (persona2.getIMC()){
            case 0 ->  System.out.println("Person is underweigth " );
            case 1 -> System.out.println("Person is  healthy ");
            default ->     System.out.println("Person is overweigth " );
        }
    }


}
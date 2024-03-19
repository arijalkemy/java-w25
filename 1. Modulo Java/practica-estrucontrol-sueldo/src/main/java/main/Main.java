package main;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        double sueldoBase;
        String dni = "12345678";
        double sueldoConAumento;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingrese el sueldo del empleado con dni " + dni + " : ");
        sueldoBase = keyboard.nextDouble();

        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase * 1.20;
        }
        else if (sueldoBase > 20000 && sueldoBase <= 45000) {
            sueldoConAumento = sueldoBase * 1.10;
        }
        else {
            sueldoConAumento = sueldoBase * 1.05;
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);

    }
}
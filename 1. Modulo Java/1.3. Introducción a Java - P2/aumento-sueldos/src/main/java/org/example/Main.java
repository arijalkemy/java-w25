package org.example;

public class Main{
    public static void main(String[] args){
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento = 0;

        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase * 1.2;
        } else if (sueldoBase > 20000 && sueldoBase <= 45000) {
            sueldoConAumento = sueldoBase * 1.1;
        } else if (sueldoBase > 45000) {
            sueldoConAumento = sueldoBase * 1.05;
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + Math.round(sueldoConAumento));
    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        Automovil auto1 = new Automovil("Ford", "Rojo", 1000);
        Automovil auto2 = new Automovil("Chevrolet", "Azul", 2000);
        Automovil auto3 = new Automovil("Fiat", "Verde", 3000);

        System.out.println(auto1.mostrarMarcaYColor());
        System.out.println(auto2.mostrarMarcaYColor());
        System.out.println(auto3.mostrarMarcaYColor());
    }
}
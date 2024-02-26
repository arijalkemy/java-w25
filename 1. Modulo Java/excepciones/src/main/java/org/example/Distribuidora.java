package org.example;

import java.sql.SQLOutput;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] stock = {
            new Perecedero("Queso", 2500, 5),
            new Perecedero("Jamon", 5000, 1),
            new NoPerecedero("Miel", 3000, "apicola"),
            new NoPerecedero("Atun enlatado", 7000, "Pescado"),
            new Perecedero("Leche", 2100, 3)
        };

        for (Producto i: stock){
            System.out.println(i.calcular(5));
        }

    }
}
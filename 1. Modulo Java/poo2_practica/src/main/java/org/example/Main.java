package org.example;

import org.example.exercise1.ExceptionsPractice;
import org.example.exercise2.Distributor;
import org.example.exercise2.NonPerishable;
import org.example.exercise2.Perishable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Exercise 1:
        ExceptionsPractice exceptionsPractice = new ExceptionsPractice();
        //exceptionsPractice.divideBandA();

        //Exercise 2:
        Distributor distributor = new Distributor(
                List.of(
                        new NonPerishable("Coca-Cola", 20, "Bebida"),
                        new Perishable("Leche", 30, 3),
                        new Perishable("Pan", 40, 1),
                        new NonPerishable("Cerveza", 50, "Bebida")
                )
        );
        int productIndex = 1;
        int productQuantity = 5;
        System.out.println("El total a pagar por "+productQuantity+" unidades de "
                + distributor.getProductList().get(productIndex).getName() + " son "
                + distributor.totalSellAmount(productIndex, productQuantity) + " pesos.");
    }
}
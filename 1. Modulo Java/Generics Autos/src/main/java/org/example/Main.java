package org.example;

import org.example.exercise1.Basic;
import org.example.exercise1.Collector;
import org.example.exercise1.Executive;

public class Main {
    public static void main(String[] args) {
        System.out.println("TRANSACCIONES DE EJECUTIVO:");
        Executive executive = new Executive();
        executive.getTransactionList().forEach(transaction -> {
            transaction.transaccionOk();
            transaction.transaccionNoOk();
        });
        System.out.println("TRANSACCIONES DE BASIC:");
        Basic basic = new Basic();
        basic.getTransactionList().forEach(transaction -> {
            transaction.transaccionOk();
            transaction.transaccionNoOk();
        });
        System.out.println("TRANSACCIONES DE COBRADOR:");
        Collector collector = new Collector();
        collector.getTransactionList().forEach(transaction -> {
            transaction.transaccionOk();
            transaction.transaccionNoOk();
        });
    }
}
package org.bootcamp.ejercicio1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Basic client1 = new Basic();
        client1.balanceCheck();
        Executive executive = new Executive();
        executive.deposit();
        Collector collector = new Collector();
        collector.withdraw();


    }
}
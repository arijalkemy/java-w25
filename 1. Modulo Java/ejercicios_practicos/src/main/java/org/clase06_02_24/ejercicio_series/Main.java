package org.clase06_02_24.ejercicio_series;

public class Main {
    public static void main(String[] args) {
        SerialClass1 serie1 = new SerialClass1();

        System.out.println(serie1.followingValue());
        System.out.println(serie1.followingValue());
        serie1.resetValue();
        System.out.println(serie1.followingValue());

        System.out.println("-------------");

        serie1.initialValue(12);
        System.out.println(serie1.followingValue());
    }
}

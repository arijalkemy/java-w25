package org.example;

import org.example.serie.SuccesiveSerieImpl;

public class Main {
    public static void main(String[] args) {
        SuccesiveSerieImpl serie = new SuccesiveSerieImpl();
        serie.setInitialValue(1.0);
        System.out.println(serie.nextValue());
        serie.setInitialValue(2);
        System.out.println(serie.nextValue());
        serie.setInitialValue(3f);
        System.out.println(serie.getCurrentValue());
        System.out.println(serie.nextValue());
        System.out.println(serie.nextValue());
        System.out.println(serie.nextValue());
        System.out.println(serie.nextValue());
        System.out.println(serie.nextValue());
        serie.resetCurrentValue();
        System.out.println(serie.nextValue());

    }
}
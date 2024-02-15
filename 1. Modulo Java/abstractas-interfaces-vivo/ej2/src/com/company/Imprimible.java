package com.company;

public interface Imprimible {

    static void imprimir(Imprimible imprimible) {
        System.out.println(imprimible.toString());
    }
}

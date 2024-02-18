package org.example.ejercicio3.clases;

import org.example.ejercicio3.interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau, guau.");
    }

    @Override
    public void comerCarne() {
        System.out.println("Rica carne, guau.");
    }
}

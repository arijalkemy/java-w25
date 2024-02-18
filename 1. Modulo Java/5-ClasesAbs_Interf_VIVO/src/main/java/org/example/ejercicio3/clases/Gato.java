package org.example.ejercicio3.clases;

import org.example.ejercicio3.interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau, miau.");
    }

    @Override
    public void comerCarne() {
        System.out.println("Rica carne, miau.");
    }
}

package org.example.entities;

import org.example.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato está comiendo carne");
    }
}

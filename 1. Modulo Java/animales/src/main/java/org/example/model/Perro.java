package org.example.model;

import org.example.interfaces.Carnivoros;

public class Perro extends Animal implements Carnivoros {
    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }

    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }
}

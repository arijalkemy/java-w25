package org.example.entities;

import org.example.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro está comiendo carne");
    }
}

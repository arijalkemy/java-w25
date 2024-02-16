package org.example.model;

import org.example.interfaces.Herviboros;

public class Vaca extends Animal implements Herviboros {
    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierva");
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }
}

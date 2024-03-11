package org.example.entities;

import org.example.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo hierba");
    }
}

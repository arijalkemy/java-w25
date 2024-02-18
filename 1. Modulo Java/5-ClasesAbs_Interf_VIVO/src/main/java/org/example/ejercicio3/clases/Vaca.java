package org.example.ejercicio3.clases;

import org.example.ejercicio3.interfaces.IHervivoro;

public class Vaca extends Animal implements IHervivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Muu, muu.");
    }

    @Override
    public void comerHierba() {
        System.out.println("Rica hierba, muu.");
    }
}

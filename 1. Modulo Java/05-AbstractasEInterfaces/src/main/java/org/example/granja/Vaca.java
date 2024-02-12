package org.example.granja;

import org.example.granja.iterfaces.IHervivoro;

public class Vaca extends Animal implements IHervivoro {


    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("MUUUUUU!");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba...");
    }
}


package com.company;

public class Gato extends Animal implements Carnivoro{

    @Override
    protected void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Gato cazando raton");
    }
}

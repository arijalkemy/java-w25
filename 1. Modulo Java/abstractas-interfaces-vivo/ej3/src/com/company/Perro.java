package com.company;

public class Perro extends Animal implements Carnivoro{
    @Override
    protected void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro comiendo liebre");
    }
}

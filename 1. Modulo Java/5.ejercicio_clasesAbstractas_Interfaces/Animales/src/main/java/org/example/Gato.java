package org.example;

public class Gato extends Animal implements Carnivoro{

    @Override
    void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato esta comiento carne");
    }
}

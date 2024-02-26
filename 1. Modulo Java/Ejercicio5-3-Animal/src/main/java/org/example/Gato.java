package org.example;

public class Gato extends Animal implements ICarnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public String comerCarne() {
        return "Este animal come carne";
    }
}

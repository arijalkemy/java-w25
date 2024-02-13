package org.example;

public class Gato extends Animal implements ICarnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }
    @Override
    public void comer() {
        comerCarne();
    }
    @Override
    public void comerCarne() {
        System.out.println("Soy un gato comiendo carne");
    }
}

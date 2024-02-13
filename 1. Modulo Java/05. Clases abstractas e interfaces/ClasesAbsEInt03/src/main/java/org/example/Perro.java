package org.example;

public class Perro extends Animal implements ICarnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perro comiendo carne");
    }
}

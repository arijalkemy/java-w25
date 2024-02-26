package org.example;

public class Perro extends Animal implements Carnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro esta comiendo carne");
    }
}

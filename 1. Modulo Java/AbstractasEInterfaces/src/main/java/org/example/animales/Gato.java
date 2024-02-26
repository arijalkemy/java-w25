package org.example.animales;

public class Gato extends Animal implements Carnivoro{
    @Override
    public String emitirSonido() {
        return "miau";
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo pescado");
    }
}

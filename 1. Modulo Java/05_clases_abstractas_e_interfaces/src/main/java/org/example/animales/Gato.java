package org.example.animales;

public class Gato extends Animal implements Carnivoro, Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo atun");
    }

    

    @Override
    public void comerHierba() {
        System.out.println("Comiendo lechuga");
    }

    @Override
    public void comer() {
        comerCarne();
        comerHierba();
    }

    
}

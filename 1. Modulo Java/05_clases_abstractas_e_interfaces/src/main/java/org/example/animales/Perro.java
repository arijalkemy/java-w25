package org.example.animales;

public class Perro extends Animal implements Carnivoro, Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }

    


    @Override
    public void comerHierba() {
        System.out.println("Comiendo papa...");
        
    }

    @Override
    public void comer() {
        comerCarne();
        comerHierba();
    }

    
}

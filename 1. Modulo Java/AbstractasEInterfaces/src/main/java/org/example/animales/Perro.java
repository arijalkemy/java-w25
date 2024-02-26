package org.example.animales;

public class Perro extends Animal implements Carnivoro{
    @Override
    public String emitirSonido() {
        return "Guau";
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}

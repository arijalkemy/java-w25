package Animales;

import Interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {
    public Gato(String nombre){
        super(nombre);
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }
}

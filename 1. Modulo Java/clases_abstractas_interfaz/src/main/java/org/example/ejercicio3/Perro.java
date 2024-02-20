package org.example.ejercicio3;

import org.example.ejercicio3.Animal;
import org.example.ejercicio3.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comeCarne() {
        System.out.println("Come hueso con carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Se come un: " + animal.getClass());
    }
}

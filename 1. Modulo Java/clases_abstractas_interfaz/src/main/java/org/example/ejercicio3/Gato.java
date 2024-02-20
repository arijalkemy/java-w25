package org.example.ejercicio3;

import org.example.ejercicio3.Animal;
import org.example.ejercicio3.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comeCarne() {
        System.out.println("Come atún");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Se come un: " + animal.getClass());
    }
}

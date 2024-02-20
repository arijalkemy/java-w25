package org.example.ejercicio3;

import org.example.ejercicio3.Animal;
import org.example.ejercicio3.Herbivoro;

public class Vaca extends Animal implements Herbivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comeHierba() {
        System.out.println("Come pasto");
    }
}

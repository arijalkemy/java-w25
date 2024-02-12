package Ejercicio3.classes;

import Ejercicio3.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne.");
    }

    public void comer() {
        comerCarne();
    }
}

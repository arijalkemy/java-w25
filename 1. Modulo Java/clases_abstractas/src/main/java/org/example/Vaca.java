package org.example;

public class Vaca extends Animal implements Herbivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuuuuuuuuu");
    }

    @Override
    public void ComeHierba() {
        System.out.println("Come pasto");
    }
}

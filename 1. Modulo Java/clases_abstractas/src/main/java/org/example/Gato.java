package org.example;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Meowwwwwww");
    }

    @Override
    public void ComeCarne() {
        System.out.println("Come atún");
    }

    @Override
    public void ComeAnimal(Animal animal) {
        System.out.println("Se come un: " + animal.getClass());
    }
}

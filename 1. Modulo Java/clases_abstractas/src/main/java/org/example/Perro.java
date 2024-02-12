package org.example;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Guauuuuuuuu");
    }

    @Override
    public void ComeCarne() {
        System.out.println("Come hueso con carne");
    }

    @Override
    public void ComeAnimal(Animal animal) {
        System.out.println("Se come un: " + animal);
    }
}

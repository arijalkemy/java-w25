package entity;

import service.ICarnivorous;
import service.IHerbivorous;

public class Dog extends Animal implements IHerbivorous, ICarnivorous {
    @Override
    public void makeSound() {
        System.out.println("El perro hace guau");
    }

    @Override
    public void eatMeat() {
        System.out.println("El perro come carne");
    }

    @Override
    public void eatAnimal(Animal animal) {
        System.out.println("El perro se come a " + animal);
    }

    @Override
    public void eatGrass() {
        System.out.println("El perro come hierba");
    }

    @Override
    public String toString() {
        return "Dog{}";
    }
}

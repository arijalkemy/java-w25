package entity;

import service.ICarnivorous;
import service.IHerbivorous;

public class Cat extends Animal implements ICarnivorous, IHerbivorous {
    @Override
    public void makeSound() {
        System.out.println("El gato hace miau");
    }

    @Override
    public void eatMeat() {
        System.out.println("El gato come carne");
    }

    @Override
    public void eatAnimal(Animal animal) {
        System.out.println("El gato come  " + animal.getClass());
    }

    @Override
    public void eatGrass() {
        System.out.println("El gato come hierbaxs");
    }

    @Override
    public String toString() {
        return "Cat{}";
    }
}

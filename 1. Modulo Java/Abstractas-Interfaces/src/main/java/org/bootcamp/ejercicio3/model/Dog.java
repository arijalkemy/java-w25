package org.bootcamp.ejercicio3.model;

import org.bootcamp.ejercicio3.interfaces.ICarnivorous;

public class Dog extends Animal implements ICarnivorous {
    public Dog(String type) {
        super(type);
    }

    @Override
    public void makeSound() {
        System.out.println("Guau");
    }

    @Override
    public void eat() {
        eatMeat();
    }

    @Override
    public void eatMeat() {
        System.out.println("Eating meat");
    }
}

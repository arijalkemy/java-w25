package org.bootcamp.ejercicio3.model;

import org.bootcamp.ejercicio3.interfaces.ICarnivorous;

public class Cat extends Animal implements ICarnivorous {
    public Cat(String type) {
        super(type);
    }

    @Override
    public void eatMeat() {
        System.out.println("Eating meat");
    }

    @Override
    public void eat() {
        eatMeat();
    }

    @Override
    public void makeSound() {
        System.out.println("Miau");
    }
}

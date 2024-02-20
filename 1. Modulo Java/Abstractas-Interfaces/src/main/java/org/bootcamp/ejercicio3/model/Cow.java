package org.bootcamp.ejercicio3.model;

import org.bootcamp.ejercicio3.interfaces.IHerbivorous;

public class Cow extends Animal implements IHerbivorous {
    public Cow(String type) {
        super(type);
    }

    @Override
    public void eatGrass() {
        System.out.println("Eating grass");
    }

    @Override
    public void eat() {
        eatGrass();
    }

    @Override
    public void makeSound() {
        System.out.println("Muuu");
    }
}

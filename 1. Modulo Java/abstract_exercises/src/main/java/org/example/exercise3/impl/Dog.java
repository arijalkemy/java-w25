package org.example.exercise3.impl;

import org.example.exercise3.Animal;
import org.example.exercise3.ICarnivorous;

public class Dog extends Animal implements ICarnivorous {
    @Override
    public void makeSound() {
        System.out.println("Guau");
    }

    @Override
    public void eatMeat() {
        System.out.println("Soy un perro comiendo carne");
    }
}

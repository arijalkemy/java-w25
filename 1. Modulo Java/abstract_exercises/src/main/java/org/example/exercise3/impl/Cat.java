package org.example.exercise3.impl;

import org.example.exercise3.Animal;
import org.example.exercise3.ICarnivorous;

public class Cat extends Animal implements ICarnivorous {

    @Override
    public void makeSound() {
        System.out.println("Miau");
    }
    @Override
    public void eatMeat() {
        System.out.println("Soy un gato comiendo carne");
    }
}

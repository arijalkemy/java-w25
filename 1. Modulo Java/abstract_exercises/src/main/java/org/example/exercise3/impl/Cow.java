package org.example.exercise3.impl;

import org.example.exercise3.Animal;
import org.example.exercise3.IHerbivorous;

public class Cow extends Animal implements IHerbivorous {
    @Override
    public void makeSound() {
        System.out.println("Muuu");
    }

    @Override
    public void eatGrass() {
        System.out.println("Soy una vaca comiendo hierba");
    }
}

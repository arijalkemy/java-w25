package entity;

import service.IHerbivorous;

public class Cow extends Animal implements IHerbivorous {
    @Override
    public void makeSound() {
        System.out.println("La vaca hace muuuuu");
    }

    @Override
    public void eatGrass() {
        System.out.println("La vaca come hierba");
    }

    @Override
    public String toString() {
        return "Cow{}";
    }
}

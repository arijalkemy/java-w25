package org.bootcamp.ejercicio3.model;

import org.bootcamp.ejercicio2.interfaces.IPrintable;
import org.bootcamp.ejercicio2.model.BookPdf;
import org.bootcamp.ejercicio2.model.Report;
import org.bootcamp.ejercicio3.interfaces.IActionAnimal;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Carnivorous");
        Cat cat = new Cat("Carnivoruos");
        Cow cow = new Cow("Herbivorius");

        dog.makeSound();
        dog.eatMeat();
        IActionAnimal.eatAnimal(dog);

        cat.makeSound();
        cat.eatMeat();
        IActionAnimal.eatAnimal(cat);

        cow.makeSound();
        cow.eatGrass();
        IActionAnimal.eatAnimal(cow);
    }
}
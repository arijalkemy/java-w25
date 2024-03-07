package org.bootcamp.ejercicio3.interfaces;

import org.bootcamp.ejercicio3.model.Animal;

public interface IActionAnimal {
    static void eatAnimal(Animal animal){
        animal.eat();
    }
}

package org.bootcamp.ejercicio3.model;

public abstract class Animal{
 protected String type;

    public Animal(String type) {
        this.type = type;
    }

    public abstract void makeSound();
    public abstract void eat();


}

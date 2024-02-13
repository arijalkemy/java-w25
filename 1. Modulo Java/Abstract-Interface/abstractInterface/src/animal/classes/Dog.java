package animal.classes;

import animal.interfaces.Carnivore;

public class Dog extends Animal implements Carnivore {

    public Dog(String name, String color) {
        super(name, color);
        this.type = "Perro";
    }

    @Override
    public void makeSound() {
        System.out.println("Guau!!");
    }

    @Override
    public void eatMeal() {
        System.out.println("Comer carne");
    }
}

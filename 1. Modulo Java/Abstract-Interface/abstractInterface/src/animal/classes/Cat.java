package animal.classes;

import animal.interfaces.Carnivore;

public class Cat extends Animal implements Carnivore {

    public Cat(String name, String color) {
        super(name, color);
        this.type = "Gato";
    }

    @Override
    public void makeSound() {
        System.out.println("Miau!!!");
    }

    @Override
    public void eatMeal() {
        System.out.println("Comer carne");
    }
}

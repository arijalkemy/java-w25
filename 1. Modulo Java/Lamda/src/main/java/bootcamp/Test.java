package bootcamp;

import bootcamp.poo.Animal;
import bootcamp.poo.Cat;
import bootcamp.poo.Dog;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal("generic");
        Animal doggie  = new Dog("Dog","chochoflan");

        doggie.showEspecie();
        doggie.makeSound();

        Animal kitty = new Cat("Cat", "chocochoco");
        kitty.showEspecie();
        kitty.makeSound();
    }
}

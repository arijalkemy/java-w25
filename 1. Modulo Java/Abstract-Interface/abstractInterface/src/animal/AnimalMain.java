package animal;

import animal.classes.Animal;
import animal.classes.Cat;
import animal.classes.Cow;
import animal.classes.Dog;

public class AnimalMain {
    public static void main(String[] args) {

        Animal gato1 = new Cat("Gatubela", "Naranja");
        Cat gato2 = new Cat("Misifu", "Negro");
        Animal perro1 = new Dog("Firulais", "Café");
        Dog perro2 = new Dog("Darwin", "Blanco");
        Animal vaca1 = new Cow("Alicia", "Blanca");
        Cow vaca2 = new Cow("Olivia", "Café");

        gato1.makeSound();
        perro1.makeSound();
        vaca1.makeSound();

        gato2.eatMeal();
        perro2.eatMeal();
        vaca2.eatHerb();

        gato2.eatAnimal(vaca1);
        perro2.eatAnimal(gato1);
    }
}

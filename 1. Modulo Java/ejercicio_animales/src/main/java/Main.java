import entity.Cat;
import entity.Cow;
import entity.Dog;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Cow cow = new Cow();
        Dog dog = new Dog();

        cat.makeSound();
        cow.makeSound();
        dog.makeSound();

        cat.eatMeat();
        cow.eatGrass();
        dog.eatAnimal(cat);
    }
}

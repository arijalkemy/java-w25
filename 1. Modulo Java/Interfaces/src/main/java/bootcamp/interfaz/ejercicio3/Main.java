package bootcamp.interfaz.ejercicio3;

public class Main {
    public static void main(String[] args) {
        Cat kitty = new Cat();
        Cow clara = new Cow();
        Dog bork = new Dog();

        kitty.makeNoise();
        clara.makeNoise();
        bork.makeNoise();

        eatAnimal(kitty);
        eatAnimal(clara);
        eatAnimal(bork);
    }

    public static void eatAnimal(Animal animal){
        animal.eatAnimal();
    }
}

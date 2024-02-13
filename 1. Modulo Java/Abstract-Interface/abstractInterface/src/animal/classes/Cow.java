package animal.classes;

import animal.interfaces.Herbivore;

public class Cow extends Animal implements Herbivore {
    public Cow(String name, String color) {
        super(name, color);
        this.type = "Vaca";
    }

    @Override
    public void makeSound() {
        System.out.println("Muuu!!!");
    }

    @Override
    public void eatHerb() {
        System.out.println("Comer Hierba");
    }
}

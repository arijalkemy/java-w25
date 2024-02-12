package bootcamp.interfaz.ejercicio3;

public class Cat extends Animal implements ICarnivoris{
    @Override
    public void makeNoise() {
        System.out.println(" Meow Meow " );
    }

    @Override
    public void eatAnimal() {
        this.eatMeat();
    }

    @Override
    public void eatMeat() {
        System.out.println(" cat eat roast chicken" );
    }
}

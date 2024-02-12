package bootcamp.interfaz.ejercicio3;

public class Dog extends Animal implements ICarnivoris{

    @Override
    public void makeNoise() {
        System.out.println(" Bark Bark " );
    }

    @Override
    public void eatAnimal() {
        eatMeat();
    }

    @Override
    public void eatMeat() {
        System.out.println(" Dog eat beaf ");
    }
}

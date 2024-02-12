package bootcamp.interfaz.ejercicio3;

public class Cow extends Animal implements  IHerbivory{

    @Override
    public void makeNoise() {
        System.out.println(" Moo Moo " );
    }

    @Override
    public void eatAnimal() {
        eatPlants();
    }

    @Override
    public void eatPlants() {
        System.out.println(" Cow eat grass ");
    }
}

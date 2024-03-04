public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("GUAU GUAU");
    }

    @Override
    public void comerAnimal(Animal animal) {
        animal.;
    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne!");
    }
}

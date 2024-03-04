public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("MIAU MIAUUU");
    }

    @Override
    public void comerAnimal(Animal animal) {

    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne!");
    }
}

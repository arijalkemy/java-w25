package meliboot;

public class Gato extends Animal implements ICarnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Comiendo animal "+animal);
    }
}

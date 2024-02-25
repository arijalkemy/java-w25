package meliboot;

public class Perro extends Animal implements ICarnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Comiendo animal "+animal);
    }
}

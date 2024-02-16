public class Gato extends Animal implements ICarnivoro{

    public Gato(String name) {
        super(name);
    }

    @java.lang.Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @java.lang.Override
    public void comerCarne() {
        System.out.println("Gato comiendo carne");
    }

    @java.lang.Override
    public void comerAnimal(Animal animal) {
        System.out.println("Comiendo: " + animal.name);
    }
}

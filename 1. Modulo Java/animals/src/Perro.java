public class Perro extends Animal implements ICarnivoro{
    public Perro(String name) {
        super(name);
    }

    @java.lang.Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @java.lang.Override
    public void comerCarne() {
        System.out.println("Perro comiendo carne");
    }

    @java.lang.Override
    public void comerAnimal(Animal animal) {
        System.out.println("Comiendo: " + animal.name);
    }
}

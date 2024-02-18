public class Gato extends Animal implements ICarnivoro {

    public Gato() {}

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}

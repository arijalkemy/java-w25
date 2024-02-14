package bootcamp.ej3;

public class Gato extends Animal implements ICarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Gato comiendo carne");
    }
}

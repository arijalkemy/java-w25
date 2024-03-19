package main;

public class Gato extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Miau");;
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un gato comiendo carnita");
    }
}

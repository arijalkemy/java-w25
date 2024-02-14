package classes;

public class Gato extends Animal implements IAlimentacionCarne {

    public Gato() {
        this.tipo = "Gato";
    }

    @Override
    public void emitirSonido() {
        System.out.println("miau");

    }

    @Override
    public void comerCarne() {
        System.out.println("gato come carne");
    }

}

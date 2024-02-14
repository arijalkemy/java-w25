package classes;

public class Perro extends Animal implements IAlimentacionCarne {

    public Perro() {
        this.tipo = "Perro";
    }

    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("perro come carne");
    }

}

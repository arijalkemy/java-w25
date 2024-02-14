package classes;

public class Vaca extends Animal implements IAlimentacionHierba {

    public Vaca() {
        this.tipo = "Vaca";
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("vaca come hierba");
    }

}

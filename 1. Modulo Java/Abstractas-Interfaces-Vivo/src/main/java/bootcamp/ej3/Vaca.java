package bootcamp.ej3;

public class Vaca extends Animal implements IHerviboro {
    @Override
    public void emitirSonido() {
        System.out.println("MUU");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca comiendo hierba");
    }
}

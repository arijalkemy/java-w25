package meliboot;

public class Vaca extends Animal implements IHerviboro{
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierva() {
        System.out.println("Comiendo hierba");
    }
}

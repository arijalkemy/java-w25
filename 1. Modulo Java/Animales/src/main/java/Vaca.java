public class Vaca extends Animal implements Herviboro{

    @Override
    public void emitirSonido() {
        System.out.println("muu");
    }

    @Override
    public void comer() {
        comerHierba();
    }
    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca comiendo hierba");
    }
}

public class Vaca extends Animal implements IHervivoro {

    public Vaca() {}

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }
}

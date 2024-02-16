public class Vaca extends Animal implements IHerviboro{

    public Vaca(String name) {
        super(name);
    }

    @java.lang.Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @java.lang.Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }
}

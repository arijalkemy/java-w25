package main;

public class Vaca extends Animal implements IHerviboro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");;
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

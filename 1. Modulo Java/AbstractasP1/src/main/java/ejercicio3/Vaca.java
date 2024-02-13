package ejercicio3;

public class Vaca extends Animal implements IHerviboro{
    @Override
    public void emitirSonido(){
        System.out.println("Muuuu");
    };

    @Override
    public void comerHierba() {
        System.out.println("Comer hierba");
    }

    @Override
    public void comerAnimal() {
        this.comerHierba();
    }
}

package Ejercicio3;

public class Vaca extends Animal implements Hervivorable{
    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierbas");
    }
}

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("MUU MUUUU");
    }

    @Override
    public void comerAnimal(Animal animal) {

    }

    @Override
    public void comerHierba() {
        System.out.println("Como plantasss");
    }
}

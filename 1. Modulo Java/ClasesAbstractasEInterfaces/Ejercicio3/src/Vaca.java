import Interfaces.IHervivoro;

public class Vaca extends Animal implements IHervivoro{

    @Override
    public void comerHierva() {
        System.out.println("Como hierva");
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("No como al animal"+animal.getClass().toString().replace("class", ""));
    }
}

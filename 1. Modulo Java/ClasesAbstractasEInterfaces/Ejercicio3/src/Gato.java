import Interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro{

    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerAnimal(Animal animal) {
        //this.comerCarne();
        System.out.println("Como al animal"+animal.getClass().toString().replace("class", ""));
    }
    
}

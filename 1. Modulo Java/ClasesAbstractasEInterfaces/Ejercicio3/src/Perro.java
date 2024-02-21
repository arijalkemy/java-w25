import Interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro{

    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }
    
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Como al animal"+animal.getClass().toString().replace("class", ""));
    }
}

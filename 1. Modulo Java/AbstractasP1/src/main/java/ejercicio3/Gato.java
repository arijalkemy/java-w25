package ejercicio3;

public class Gato extends Animal implements ICarnivoro, IHerviboro{

    @Override
    public void emitirSonido() {
        System.out.println("Miauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comer hierba");
    }

    @Override
    public void comerAnimal(){
        this.comerCarne();
        this.comerHierba();
    }
}

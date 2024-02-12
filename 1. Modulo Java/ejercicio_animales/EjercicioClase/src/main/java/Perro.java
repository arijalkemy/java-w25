public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perro comiendo carne");
    }
}

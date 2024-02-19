public class Vaca extends Animal implements IHervivoros{


    public Vaca(String nombre) {
        super(nombre);
        this.tipo = "hervivoro";
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu soy una vaca Muu");
    }

    @Override
    public void comerHierva() {
        System.out.println("Muuu que rica hierva");
    }
}

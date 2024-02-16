public class Perro extends Animal implements ICarnivoros{

    public Perro(String nombre) {
        super(nombre);
        this.tipo = "carnivoro";
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guauu soy un perro guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Guau que rica carne");
    }
}

public class Gato extends Animal implements ICarnivoros{

    public Gato(String nombre) {
        super(nombre);
        this.tipo = "carnivoro";
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miauu soy un Gato Miauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Miau que rica carne");
    }

    public void comerAnimal(Animal a){
        System.out.println("Me comi un " + a.nombre);
    }
}

public class Main {
    public static void main(String[] args) {
        Vaca v = new Vaca("Vaquita");
        Gato g = new Gato("Gatito");
        Perro p = new Perro("Perrito");

        v.emitirSonido();
        g.emitirSonido();
        p.emitirSonido();

        v.comerHierva();
        g.comerCarne();
        p.comerCarne();

        g.comerAnimal(p);
    }
}

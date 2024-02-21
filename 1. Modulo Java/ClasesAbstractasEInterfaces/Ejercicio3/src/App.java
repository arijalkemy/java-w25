public class App {
    public static void main(String[] args) throws Exception {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.comerCarne();
        perro.comerCarne();
        vaca.comerHierva();

        gato.comerAnimal(vaca);
        perro.comerAnimal(gato);
        vaca.comerAnimal(perro);
    }
}

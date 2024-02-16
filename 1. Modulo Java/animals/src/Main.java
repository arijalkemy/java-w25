public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro("Alex");
        perro.emitirSonido();

        Gato gato = new Gato("Gonzo");
        gato.emitirSonido();

        Vaca vaca = new Vaca("Blanca");
        vaca.emitirSonido();

        perro.comerAnimal(vaca);
    }
}
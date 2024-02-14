import classes.*;

public class App {
    public static void main(String[] args) throws Exception {

        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.emitirSonido();
        perro.emitirSonido();
        vaca.emitirSonido();

        gato.comerCarne();
        perro.comerCarne();
        vaca.comerHierba();
    }
}

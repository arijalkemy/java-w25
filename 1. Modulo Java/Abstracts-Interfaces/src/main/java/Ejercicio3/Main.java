package Ejercicio3;

import Ejercicio3.classes.Gato;
import Ejercicio3.classes.Perro;
import Ejercicio3.classes.Vaca;

public class Main {
    public static void main(String[] args){
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        vaca.emitirSonido();
        vaca.comerHierba();

        perro.emitirSonido();
        perro.comerCarne();

        gato.emitirSonido();
        gato.comerCarne();
    }
}

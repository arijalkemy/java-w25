package bootcamp;

import bootcamp.ej2.Curriculum;
import bootcamp.ej2.IImprimible;
import bootcamp.ej2.Informe;
import bootcamp.ej2.LibroPDF;
import bootcamp.ej3.Animal;
import bootcamp.ej3.Gato;
import bootcamp.ej3.Perro;
import bootcamp.ej3.Vaca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.List;


public class Main
{
    public static void main( String[] args ) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
    }

    public static void ejercicio1() {

    }

    public static void ejercicio2() {
        Curriculum curriculum = new Curriculum("Mondongo", new ArrayList<>(Arrays.asList("Volar", "Nadar")));
        LibroPDF pdf = new LibroPDF(35, "Fulano Goyes", "Transacciones", "Bancario");
        Informe informe = new Informe("Informe corto.", 1, "Anónimo", "Alguien");

        List<IImprimible> documentos = new ArrayList<>(Arrays.asList(curriculum, pdf, informe));
        documentos.forEach(IImprimible::imprimir);
    }

    public static void ejercicio3() {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        List<Animal> animales = new ArrayList<>(Arrays.asList(perro, gato, vaca));
        animales.forEach(Animal::emitirSonido);

        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Perro perro) {
        perro.comerCarne();
    }

    public static void comerAnimal(Gato gato) {
        gato.comerCarne();
    }

    public static void comerAnimal(Vaca vaca) {
        vaca.comerHierba();
    }
}

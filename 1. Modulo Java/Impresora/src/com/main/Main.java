package com.main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Responsable");
        habilidades.add("Puntual");
        Curriculum curriculum = new Curriculum("Juan Pérez", "12345",34,habilidades);
        Libros libro = new Libros(300, "Gabriel García Márquez", "Cien años de soledad", "Realismo mágico");
        Informes informe = new Informes("Este es el texto del informe...", 10, "Ana Gómez", "Pedro López");


        curriculum.imprimirDocumeto();
        libro.imprimirDocumeto();
        informe.imprimirDocumeto();
    }
}

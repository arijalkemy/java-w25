package org.example;

import org.example.interfaces.Imprimir;
import org.example.model.Curriculum;
import org.example.model.Informes;
import org.example.model.LibroPDF;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = List.of("Responsable", "Puntual");
        Curriculum curriculum = new Curriculum("Pepito", "Perez", 12345, list);
        Imprimir.imprimirDocumento(curriculum);

        Informes informes = new Informes("Jose Gomez", "Raul Ceballos", "Contenido del informe", "2");
        Imprimir.imprimirDocumento(informes);

        LibroPDF libro = new LibroPDF(12, "Lucas Lopez", "Aprendiendo Java", "Educacion");
        Imprimir.imprimirDocumento(libro);
    }
}
package org.example;

import org.example.entities.Curriculum;
import org.example.entities.Informe;
import org.example.entities.LibroEnPDF;
import org.example.entities.Persona;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Valentín","Campestri","42800000");

        Curriculum curriculum = new Curriculum(persona);
        Informe informe = new Informe(
                "Lorem Ipsum",
                20,
                "Messi",
                "Kimba"
        );
        LibroEnPDF libro = new LibroEnPDF(
                200,
                "Cristiano",
                "Fútbol",
                "Deporte"
        );

        curriculum.imprimir();
        informe.imprimir();
        libro.imprimir();

    }
}
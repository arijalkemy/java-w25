package org.example;

import org.example.Documentos.Curriculum;
import org.example.Documentos.Informe;
import org.example.Documentos.Libro;
import org.example.Interfaces.Imprimible;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Informe informe = new Informe("Contenido del informe",100,"Totti","Juan _Manuel");
        Libro libro = new Libro(100,"Juan Manuel","Aventuras de un programador","Aventura");
        Curriculum curriculum = new Curriculum("Juan","Manuel","Soy un programador","Experiencia laboral",new ArrayList<String>());

        Imprimible.imprimirDocumento(informe);
        Imprimible.imprimirDocumento(libro);
        Imprimible.imprimirDocumento(curriculum);

        Imprimible.imprimirDocumento2(informe);
        Imprimible.imprimirDocumento2(libro);
        Imprimible.imprimirDocumento2(curriculum);
    }
}

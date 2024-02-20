package org.example.ejercicio2;

import java.util.List;

public class MainDocumento {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Clara","Argentina", new String[]{"organizativa", "social"});
        LibroPDF libroPdf = new LibroPDF(10,"autor1", "titulo1", "accion");
        Informe informe = new Informe("texto1",20,"autor2","revisor2");

        cv.imprimir();
        libroPdf.imprimir();
        informe.imprimir();
    }
}

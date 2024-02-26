package org.example.documentos;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Imprimible curriculum = new Curriculums("juan","zapata", 18, "293293" , new ArrayList<>());
        Imprimible informe = new Informes(213,"julio verne", "viaje al centro de la tierra" , "fantasia");
        Imprimible libro = new LibrosEnPDF("aiefn", 123, "JK", "jan");

        curriculum.imprimible();
        informe.imprimible();
        libro.imprimible();
    }
}

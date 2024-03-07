package org.bootcamp.ejercicio2.interfaces;

import org.bootcamp.ejercicio2.model.Document;

public interface IPrintable {
    static void print(Document document) {

        System.out.println("Imprimiendo "+document.getTypeDocument());
        System.out.println(document.toString());
    }
}

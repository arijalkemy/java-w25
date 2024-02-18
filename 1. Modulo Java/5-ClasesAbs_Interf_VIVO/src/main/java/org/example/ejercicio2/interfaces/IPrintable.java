package org.example.ejercicio2.interfaces;

import org.example.ejercicio2.clases.Document;

public interface IPrintable {
    static void printDocument(Document document) {
        document.print();
    };
    void printFileType();
}

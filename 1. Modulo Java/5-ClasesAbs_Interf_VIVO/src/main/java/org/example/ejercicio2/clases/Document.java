package org.example.ejercicio2.clases;

import org.example.ejercicio2.interfaces.IPrintable;

public abstract class Document implements IPrintable {
    public abstract void print();
    @Override
    public void printFileType() {
        System.out.println("----------" + getClass().getSimpleName().toUpperCase() + "----------");
    };
}

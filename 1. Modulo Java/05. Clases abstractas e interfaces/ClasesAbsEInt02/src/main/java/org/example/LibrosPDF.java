package org.example;

public class LibrosPDF implements IImprimible{
    @Override
    public void imprimir() {
        System.out.println("Soy un libro pdf");
    }
}

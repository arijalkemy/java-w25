package com.company;

public class Main {

    public static void main(String[] args) {

        LibroPDF libroPDF = new LibroPDF("Clean code","IT","Tio bob",200);

        Imprimible.imprimir(libroPDF);
    }
}

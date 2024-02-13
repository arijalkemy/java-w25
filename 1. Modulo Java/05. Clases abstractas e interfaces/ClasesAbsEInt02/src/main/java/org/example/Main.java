package org.example;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum();
        Informe informe = new Informe();
        LibrosPDF libro = new LibrosPDF();

        imprimir(curriculum);
        imprimir(informe);
        imprimir(libro);
    }

    public static void imprimir(IImprimible archivo){
        archivo.imprimir();
    }
}
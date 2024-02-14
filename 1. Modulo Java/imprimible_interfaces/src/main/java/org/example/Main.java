package org.example;

public class Main {
    public static void main(String[] args) {
  Documento documento = new Informe();
    Imprimible.imprimir(documento);
    Documento documento2 = new Libro();
    Imprimible.imprimir(documento2);
    Documento document3 = new Curriculum();
    Imprimible.imprimir(document3);
    }
}
package org.example.model;

public class LibroPDF extends Documento{

    private Integer numeroPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(Integer numeroPaginas, String autor, String titulo, String genero) {
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo datos del libro:");
        System.out.println(" - Autor: " + autor);
        System.out.println(" - Titulo: " + titulo);
        System.out.println(" - Genero: " + genero);
    }
}

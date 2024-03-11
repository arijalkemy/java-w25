package org.example.entities;

import org.example.Interfaces.Imprimible;

public class LibroEnPDF implements Imprimible {
    private int cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroEnPDF(int cantidadDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Impresión de informe: ");
        System.out.println(toString());
    }
}

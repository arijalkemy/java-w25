package model;

import interfaces.Imprimible;

public class LibroPDF implements Imprimible {
    private int cantidadPaginas;
    private String autor, titulo, genero;

    public LibroPDF(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo libro.pdf...");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'';
    }
}

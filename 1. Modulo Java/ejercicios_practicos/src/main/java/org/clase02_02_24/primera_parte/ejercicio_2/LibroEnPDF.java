package org.clase02_02_24.primera_parte.ejercicio_2;

public class LibroEnPDF implements Imprimible<LibroEnPDF>{
    int cantidadPaginas;
    String autor;
    String titulo;
    String genero;
    @Override
    public void imprimir() {
        System.out.println("Se esta imprimiendo el libro: " + this);
    }

    @Override
    public String toString() {
        return "LibroEnPDF{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}

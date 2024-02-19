package com.main;

public class Libros implements IImprimible{
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public Libros(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimirDocumeto() {
        System.out.println("--- Libro ---");
        System.out.println("Autor: "+nombreAutor);
        System.out.println("Titulo: "+titulo);
        System.out.println("Cantidad Paginas: "+cantidadPaginas);
        System.out.println("Genero: "+genero);
    }
}

package org.example.Documentos;

import org.example.Interfaces.Imprimible;

public class Libro implements Imprimible {
    int cantidadDePaginas;
    String nombreDeAutor;
    String titulo;
    String genero;

    public Libro (int cantidadDePaginas, String nombreDeAutor, String titulo, String genero){
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDeAutor = nombreDeAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + nombreDeAutor);
        System.out.println("Genero: " + genero);
        System.out.println("Cantidad de páginas: " + cantidadDePaginas);
        System.out.println();
    }
}

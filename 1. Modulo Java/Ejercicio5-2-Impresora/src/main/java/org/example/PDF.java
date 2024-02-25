package org.example;

public class PDF extends Documento{
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public PDF(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo del libro: "+titulo);
        System.out.println("Número de páginas: "+cantidadPaginas);
        System.out.println("Autor: "+autor);
        System.out.println("Género: "+genero);
    }
}

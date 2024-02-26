package org.example;

public class LibroPDF implements Imprimible{
    int paginas;
    String autor;
    String titulo;
    String genero;

    public LibroPDF(int paginas, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro " + titulo);
        System.out.println("Autor " + autor);
        System.out.println("Paginas " + paginas);
        System.out.println("Genero " + genero);
    }
}

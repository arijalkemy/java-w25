package org.example.ejercicio_2_documentos.documento;

public class LibroPDF extends Documento {
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantPaginas, String autor, String titulo, String genero) {
        super(cantPaginas);
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public LibroPDF(){};

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("-------------------------");
        System.out.println("       Libro PDF        ");
        System.out.println("-------------------------");
        System.out.println("Autor: " + this.autor);
        System.out.println("Título: " + this.titulo);
        System.out.println("Género: " + this.genero);
        System.out.println("Cant. páginas: " + super.getCantPaginas());
        System.out.println("-------------------------");
    }
}

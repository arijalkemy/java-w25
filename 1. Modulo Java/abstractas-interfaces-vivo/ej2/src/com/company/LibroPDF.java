package com.company;

public class LibroPDF implements Imprimible{
    private String titulo;
    private String genero;
    private String nombreAutor;
    private int cantidadPaginas;

    public LibroPDF(String titulo, String genero, String nombreAutor, int cantidadPaginas) {
        this.titulo = titulo;
        this.genero = genero;
        this.nombreAutor = nombreAutor;
        this.cantidadPaginas = cantidadPaginas;
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

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                '}';
    }
}

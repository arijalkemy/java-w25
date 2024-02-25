package org.example;

public class Informe extends Documento{
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println(texto);
        System.out.println("Cantidad de páginas: "+cantidadPaginas);
        System.out.println("Autor: "+autor);
        System.out.println("Revisado por: "+revisor);
    }
}

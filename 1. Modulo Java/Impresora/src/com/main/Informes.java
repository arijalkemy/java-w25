package com.main;

public class Informes implements IImprimible{
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informes(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimirDocumeto() {
        System.out.println("--- Informe ---");
        System.out.println("Autor: "+autor);
        System.out.println("Revisor: "+revisor);
        System.out.println("Cantidad Paginas: "+cantidadPaginas);
        System.out.println("Texto: "+texto);

    }
}

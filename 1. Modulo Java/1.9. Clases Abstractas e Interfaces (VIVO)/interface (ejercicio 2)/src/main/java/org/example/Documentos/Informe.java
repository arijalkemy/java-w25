package org.example.Documentos;

import org.example.Interfaces.Imprimible;

public class Informe implements Imprimible{
    private String contenido;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(String contenido, int cantidadPaginas, String autor, String revisor) {
        this.contenido = contenido;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimir Informe");
        System.out.println("Contenido: " + contenido);
        System.out.println("Cantidad páginas: " + cantidadPaginas);
        System.out.println("Autor: " +  autor);
        System.out.println("Revisor: " + revisor);
        System.out.println();
    }

}

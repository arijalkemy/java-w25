package org.example.model;

public class Informes extends Documento{

    private String autor;
    private String revisor;
    private String texto;
    private String numeroPaginas;

    public Informes(String autor, String revisor, String texto, String numeroPaginas) {
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Datos del informe:");
        System.out.println(" - Autor: " + autor);
        System.out.println(" - Revisor: " + revisor);
        System.out.println(" - Numero de paginas: " + numeroPaginas);
        System.out.println(" - Contenido: " + texto);

    }
}

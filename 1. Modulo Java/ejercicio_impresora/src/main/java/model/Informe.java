package model;

import interfaces.Imprimible;

public class Informe implements Imprimible {
    private String texto, autor, revisor;
    private int cantidadPaginas;

    public Informe(String texto, String autor, String revisor, int cantidadPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe...");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas;
    }
}

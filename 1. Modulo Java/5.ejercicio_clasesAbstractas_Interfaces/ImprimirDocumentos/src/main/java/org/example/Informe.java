package org.example;

public class Informe implements Imprimible{

    String texto;
    int paginas;
    String autor;
    String revisor;

    public Informe(String texto, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.print("Informe de: " + autor);
        System.out.print("Revisor: " + revisor);
        System.out.print("Paginas: " + paginas);
        System.out.print("Texto: " + texto);
    }
}

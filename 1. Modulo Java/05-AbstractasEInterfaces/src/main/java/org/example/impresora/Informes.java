package org.example.impresora;

public class Informes implements Imprimible{
    private String texto;

    private int paginas;

    private String autor;

    private String revisor;


    public Informes(String texto, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }


    @Override
    public String toString() {
        return "Informes{" +
                "texto='" + texto + '\'' +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }


    @Override
    public void printDocument() {
        System.out.println(this);
    }
}

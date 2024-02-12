package Ejercicio2;

public class Informe extends Documento {
    private String texto;
    private String autor;
    private String revisor;
    private Integer cantPag;

    public Informe(String texto, String autor, String revisor, Integer cantPag) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.cantPag = cantPag;
    }

    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println("Cantidad de Páginas: " + cantPag);
        System.out.println("Texto: " + texto);
    }
}

package org.example.ejercicio_2_documentos.documento;

public class Informe extends Documento{
    private String autor;
    private String revisor;
    private String texto;

    public Informe(int cantPaginas, String autor, String revisor, String texto) {
        super(cantPaginas);
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }

    public Informe() {}

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public void imprimir() {
        System.out.println("-------------------------");
        System.out.println("       Informe        ");
        System.out.println("-------------------------");
        System.out.println("Autor: " + this.autor);
        System.out.println("Revisor: " + this.revisor);
        System.out.println("Texto: " + this.texto);
        System.out.println("Cant. páginas: " + super.getCantPaginas());
        System.out.println("-------------------------");
    }
}

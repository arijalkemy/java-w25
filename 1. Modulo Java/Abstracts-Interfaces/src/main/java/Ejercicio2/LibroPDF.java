package Ejercicio2;

public class LibroPDF extends Documento{
    private Integer cantPag;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(Integer cantPag, String autor, String titulo, String genero) {
        this.cantPag = cantPag;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Genero: " + genero);
        System.out.println("Cantidad de Paginas: " + cantPag);
    }
}

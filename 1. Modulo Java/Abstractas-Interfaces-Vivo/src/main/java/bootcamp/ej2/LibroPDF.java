package bootcamp.ej2;

import java.util.List;

public class LibroPDF extends Documento {
    private Integer cantidadDePaginas;
    private String nombreDeAutor;
    private String titulo;
    private String genero;

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", nombreDeAutor='" + nombreDeAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }


    public LibroPDF(Integer cantidadDePaginas, String nombreDeAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDeAutor = nombreDeAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}

package Ejercicio_Clases_Abs_Int.src.Ejercicio2;

public class LibroPdf implements  IImprimible{
    private int cantPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPdf(int cantPaginas, String nombreAutor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public LibroPdf() {
    }

    public void imprimir() {
        System.out.println("Imprimiendo Libro tipo PDF...");
    }
}

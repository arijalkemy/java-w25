package ejercicio2;

public class Libros extends Documento{

    private int cantPaginas;
    private String nombre;
    private String autor;
    private String titulo;
    private String genero;

    public Libros(int cantPaginas, String nombre, String autor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombre = nombre;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Imprimir Libro";
    }
}

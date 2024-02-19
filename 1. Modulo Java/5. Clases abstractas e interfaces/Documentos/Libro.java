public class Libro implements Imprimible{

    int cantidadDePaginas;
    String nombreAutor;
    String titulo;
    String genero;

    public Libro(int cantidadDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void Imprimir () {
        System.out.println("Libro{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}');
    }
}

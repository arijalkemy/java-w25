package classes;

public class LibroPDF implements IMostrarContenido {

    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void mostrarContenido() {
        System.out.println(
                "LibroPDF [cantidadPaginas=" + cantidadPaginas + ", autor=" + autor + ", titulo=" + titulo + ", genero="
                        + genero + "]");
    }

}

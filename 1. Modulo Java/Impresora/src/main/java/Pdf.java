public class Pdf extends Documento {
    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public Pdf(String texto, int cantidadDePaginas, String autor, String titulo, String genero) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiento PDF");
    }
}

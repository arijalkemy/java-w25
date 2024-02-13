package ejercicio2;

public class Informe extends Documento {

    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Imprimir informe\n" +
                "\ntexto: " + this.texto +
                "\ncantidad de páginas: " + this.cantidadPaginas +
                "\nautor: " + this.autor +
                "\nrevisor: " + this.revisor;
    }
}

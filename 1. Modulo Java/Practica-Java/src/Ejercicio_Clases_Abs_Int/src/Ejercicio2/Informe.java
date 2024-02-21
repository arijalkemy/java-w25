package Ejercicio_Clases_Abs_Int.src.Ejercicio2;

public class Informe implements IImprimible{
    private String texto;
    private Integer cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, Integer cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public Informe() {
    }

    public void imprimir() {
        System.out.println("Imprimiendo informe...");
    }
}

package ejercicio2.clases;

public class Informes extends Documentos {
    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public Informes(String texto, int cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        imprimirTipo(); // Utiliza este metodo ya que la clase Curriculum extiende de Documento
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println("Cantidad de paginas: " + cantPaginas);
        System.out.println(texto);
    }

    public void imprimirDocumento(Documentos documentos) {

    }

    public void imprimirTipoDoc() {

    }
}

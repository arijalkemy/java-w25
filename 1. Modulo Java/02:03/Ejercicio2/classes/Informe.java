package classes;

public class Informe
        implements IMostrarContenido {

    private String texto;
    private String autor;
    private String revisor;
    private int qPaginas;

    public Informe(String texto, String autor, String revisor, int qPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.qPaginas = qPaginas;
    }

    @Override
    public void mostrarContenido() {
        System.out.println("Informes [texto=" + texto + ", autor=" + autor + ", revisor=" + revisor + ", qPaginas="
                + qPaginas + "]");
    }

}

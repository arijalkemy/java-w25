package bootcamp.ej2;

public class Informe extends Documento {
    private String texto;
    private Integer cantidadDePaginas;
    private String autor;

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantidadDePaginas=" + cantidadDePaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    public Informe(String texto, Integer cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    private String revisor;
    @Override
    public void imprimir() {
        System.out.println(this);

    }
}

public class Informe implements Imprimible{

    int longitud;
    int cantidadPaginas;
    String autor;
    String revisor;

    public Informe(int longitud, int cantidadPaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void Imprimir() {
        System.out.println("Informe{" +
                "longitud=" + longitud +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}');
    }
}

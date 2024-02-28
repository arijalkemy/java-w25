public class Informe implements IImprimir{
    private Texto texto;
    private int cantidadPaginas;
    private String nombreAutor;
    private String nombreRevisor;

    public Informe(Texto texto, int cantidadPaginas, String nombreAutor, String nombreRevisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.nombreRevisor = nombreRevisor;
    }

    public Texto getTexto() {
        return texto;
    }

    public void setTexto(Texto texto) {
        this.texto = texto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNombreRevisor() {
        return nombreRevisor;
    }

    public void setNombreRevisor(String nombreRevisor) {
        this.nombreRevisor = nombreRevisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto=" + texto +
                ", cantidadPaginas=" + cantidadPaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", nombreRevisor='" + nombreRevisor + '\'' +
                '}';
    }


    @Override
    public void imprimir() {
        System.out.println(this);
    }
}

package Ejercicio2;

public class Informe implements IImprimible{
    private String texto;
    private Integer cantPaginas;
    private String autor;
    private String revisor;

    @Override
    public void imprimirTipoDoc() {
        System.out.println("Texto:\n" + texto);
    }
}

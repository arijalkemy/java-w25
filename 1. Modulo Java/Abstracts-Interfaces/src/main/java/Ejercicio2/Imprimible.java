package Ejercicio2;

public interface Imprimible {
    static void imprimir(Documento documento) {
        documento.imprimir();
    }

    public void imprimirTipoDoc();
}

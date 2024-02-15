package Ejercicio2;

public interface IImprimible {

    static void imprimirDocumento(Documento documento){
        documento.imprimir();
    };

    void imprimirTipoDoc();
}

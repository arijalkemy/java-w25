package org.example.impresora;

public interface IImprimible {
    static void imprimirDocumento(Documento documento){
        documento.imprimir();
    };
}

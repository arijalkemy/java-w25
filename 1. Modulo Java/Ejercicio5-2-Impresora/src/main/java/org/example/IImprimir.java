package org.example;

public interface IImprimir{
    static void imprimirDocumento(Documento tipoDocumento){
        tipoDocumento.imprimir();
    }
}

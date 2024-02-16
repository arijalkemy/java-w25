package org.example.interfaces;

import org.example.model.Documento;

public interface Imprimir {

    static void imprimirDocumento(Documento documento) {
        documento.imprimir();
    }
}

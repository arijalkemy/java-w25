package org.example.ejercicio_2_documentos;

public class ImprimirImpl implements IImprimir{
    @Override
    public void imprimir(Documento documentoAEvaluar) {

        //si el documento es tipo LibrospDF
        if (documentoAEvaluar instanceof LibrosPDF) {

            //llama al toString del tipo de documento
            documentoAEvaluar.toString();
        }
    }
}

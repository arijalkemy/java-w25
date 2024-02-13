package org.example.ejercicio_2_documentos.documento;

import org.example.ejercicio_2_documentos.interfaz.IImprimible;

public abstract class Documento implements IImprimible {
    private int cantPaginas;

    public Documento(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public Documento() {
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    @Override
    public void imprimir() {

    }
}

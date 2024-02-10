package org.example.Interfaces;

import org.example.Documentos.*;

public interface Imprimible {

    void imprimir();

    static <T> void imprimirDocumento(T documento){
        if(documento instanceof Curriculum){
            ((Curriculum) documento).imprimir();
        } else if (documento instanceof Informe){
            ((Informe) documento).imprimir();
        } else if(documento instanceof Libro){
            ((Libro) documento).imprimir();
        } else System.out.println("Este documento no se puede imprimir");
    }
    
    static void imprimirDocumento2(Imprimible documento){
        documento.imprimir();
    }
}

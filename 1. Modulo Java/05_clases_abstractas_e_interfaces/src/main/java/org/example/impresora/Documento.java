package org.example.impresora;

public abstract class Documento implements IImprimible{
    public void imprimir(){
        System.out.println(this);
    };
}

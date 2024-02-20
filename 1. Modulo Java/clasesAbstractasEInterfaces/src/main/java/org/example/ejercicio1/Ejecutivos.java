package org.example.ejercicio1;

import java.util.List;

public class Ejecutivos extends Cliente{
    public Ejecutivos(){
        super(List.of(new Deposito(), new Transferencia()));
    }
}

package org.example;

public class Ejecutivo extends Cliente{
    ITransaccion transferencia = new Transferencia();
    ITransaccion deposito = new Deposito();

}

package org.example;

public class Basic extends Cliente{
    ITransaccion consultaSaldo = new ConsultaSaldo();
    ITransaccion pagoServicio = new PagoServicios();
    ITransaccion retiroEfectivo = new RetiroEfectivo();
}

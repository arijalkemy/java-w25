package org.example.ejercicio1;
import org.example.ejercicio1.Basic;
import org.example.ejercicio1.Ejecutivos;
import org.example.ejercicio1.Cobrador;

public class Main {
    public static void main(String[] args) {
        System.out.println("TRANSACCIONES DE EJECUTIVO:");
        Ejecutivos ejecutivos = new Ejecutivos();
        ejecutivos.getListaTransaccion().forEach(transaccion -> {
            transaccion.transaccionOK();
            transaccion.transaccionNoOK();
        });
        System.out.println("TRANSACCIONES DE BASIC:");
        Basic basic = new Basic();
        basic.getListaTransaccion().forEach(transaccion -> {
            transaccion.transaccionOk();
            transaccion.transaccionNoOk();
        });
        System.out.println("TRANSACCIONES DE COBRADOR:");
        Cobrador cobrador = new Cobrador();
        cobrador.getTransactionList().forEach(transaccion -> {
            transaccion.transaccionOk();
            transaccion.transaccionNoOk();
        });
    }
}
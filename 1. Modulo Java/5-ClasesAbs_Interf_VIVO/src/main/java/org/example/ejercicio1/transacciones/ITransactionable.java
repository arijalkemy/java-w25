package org.example.ejercicio1.transacciones;

public interface ITransactionable {
    void transactionOk(String message);
    void transactionNotOk(String message);
}

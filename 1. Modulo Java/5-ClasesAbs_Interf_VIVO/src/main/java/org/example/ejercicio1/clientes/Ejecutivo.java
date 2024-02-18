package org.example.ejercicio1.clientes;

import org.example.ejercicio1.transacciones.IDepositable;
import org.example.ejercicio1.transacciones.IWithdrawable;

public class Ejecutivo implements IDepositable, IWithdrawable {

    @Override
    public void deposit(boolean bool) {
        if (bool) {
            transactionOk("Depositing...");
        } else {
            transactionNotOk("Deposit failed.");
        }
    }

    @Override
    public void withdrawal(boolean bool) {
        if (bool) {
            transactionOk("Withdrawing.");
        } else {
            transactionNotOk("Withdrawal failed.");
        }
    }

    @Override
    public void transactionOk(String message) {
        System.out.println(message);
    }

    @Override
    public void transactionNotOk(String message) {
        System.out.println(message);
    }
}

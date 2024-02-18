package org.example.ejercicio1.clientes;

import org.example.ejercicio1.transacciones.IConsultable;
import org.example.ejercicio1.transacciones.IExtractable;
import org.example.ejercicio1.transacciones.IPayable;

public class Basic implements IConsultable, IPayable, IExtractable {
    @Override
    public void consult(boolean bool) {
        if (bool) {
            transactionOk("Consulting...");
        } else {
            transactionNotOk("Consultation failed.");
        }
    }

    @Override
    public void extract(boolean bool) {
        if (bool) {
            transactionOk("Extracting...");
        } else {
            transactionNotOk("Extraction failed.");
        }
    }

    @Override
    public void pay(boolean bool) {
        if (bool) {
            transactionOk("Paying...");
        } else {
            transactionNotOk("Payment failed.");
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

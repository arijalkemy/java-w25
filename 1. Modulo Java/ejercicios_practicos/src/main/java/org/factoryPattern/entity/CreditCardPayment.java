package org.factoryPattern.entity;

import org.factoryPattern.repository.Payment;

public class CreditCardPayment implements Payment {
    @Override
    public void doPayment() {
        System.out.println("Paying with Credit Card.");
    }
}

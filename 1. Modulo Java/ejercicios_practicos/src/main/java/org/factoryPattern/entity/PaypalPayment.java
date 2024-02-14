package org.factoryPattern.entity;

import org.factoryPattern.repository.Payment;

public class PaypalPayment implements Payment {
    @Override
    public void doPayment() {
        System.out.println("Paying with Paypal.");
    }
}

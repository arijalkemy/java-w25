package org.factoryPattern;

import org.factoryPattern.entity.PaymentType;
import org.factoryPattern.factory.PaymentFactory;
import org.factoryPattern.repository.Payment;

public class Main {
    public static void main(String[] args) {
        testPayment();
    }

    public static void testPayment(){
        Payment payment = PaymentFactory.buildPayment(PaymentType.CREDITCARD);
        payment.doPayment();
    }
}

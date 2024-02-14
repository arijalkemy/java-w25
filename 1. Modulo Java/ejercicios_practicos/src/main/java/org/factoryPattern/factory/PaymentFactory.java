package org.factoryPattern.factory;

import org.factoryPattern.entity.CreditCardPayment;
import org.factoryPattern.entity.GooglePayment;
import org.factoryPattern.entity.PaymentType;
import org.factoryPattern.entity.PaypalPayment;
import org.factoryPattern.repository.Payment;

public class PaymentFactory {
    public static Payment buildPayment(PaymentType paymentType){
        return switch (paymentType) {
            case PAYPAL -> new PaypalPayment();
            case GOOGLEPAYMENT -> new GooglePayment();
            case CREDITCARD -> new CreditCardPayment();
        };
    }
}

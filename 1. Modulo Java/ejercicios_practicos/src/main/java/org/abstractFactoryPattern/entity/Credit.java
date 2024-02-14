package org.abstractFactoryPattern.entity;

import org.abstractFactoryPattern.repository.PaymentMethod;

public class Credit implements PaymentMethod {
    @Override
    public String doPayment() {
        return "Pago a crédito";
    }
}

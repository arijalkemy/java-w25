package org.abstractFactoryPattern.entity;

import org.abstractFactoryPattern.repository.PaymentMethod;

public class Debit implements PaymentMethod {
    @Override
    public String doPayment() {
        return "Pago a débito";
    }
}

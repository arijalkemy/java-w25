package org.abstractFactoryPattern.factory;

import org.abstractFactoryPattern.repository.AbstractFactory;
import org.abstractFactoryPattern.repository.PaymentMethod;
import org.abstractFactoryPattern.entity.Credit;
import org.abstractFactoryPattern.entity.Debit;

public class PaymentMethodFactory implements AbstractFactory<PaymentMethod> {
    @Override
    public PaymentMethod create(String type) {
        if ("CREDIT".equals(type)){
            return new Credit();
        } else if ("DEBIT".equals(type)) {
            return new Debit();
        } else {
            return null;
        }
    }
}

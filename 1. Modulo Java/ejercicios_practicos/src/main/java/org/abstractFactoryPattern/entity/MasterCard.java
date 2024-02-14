package org.abstractFactoryPattern.entity;

import org.abstractFactoryPattern.repository.Card;

public class MasterCard implements Card {
    @Override
    public String getCardType() {
        return "MASTERCARD";
    }

    @Override
    public String getCardNumber() {
        return "0000 0000 0000 0000";
    }
}

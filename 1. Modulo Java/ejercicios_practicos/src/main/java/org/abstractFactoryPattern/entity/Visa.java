package org.abstractFactoryPattern.entity;

import org.abstractFactoryPattern.repository.Card;

public class Visa implements Card {
    @Override
    public String getCardType() {
        return "VISA";
    }

    @Override
    public String getCardNumber() {
        return "0000 0000 0000 0000";
    }
}

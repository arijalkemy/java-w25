package org.abstractFactoryPattern.factory;

import org.abstractFactoryPattern.repository.AbstractFactory;
import org.abstractFactoryPattern.repository.Card;
import org.abstractFactoryPattern.entity.MasterCard;
import org.abstractFactoryPattern.entity.Visa;

public class CardFactory implements AbstractFactory<Card> {
    @Override
    public Card create(String type) {
        if ("VISA".equals(type)){
            return new Visa();
        } else if ("MASTERCARD".equals(type)) {
            return new MasterCard();
        }
        return null;
    }
}

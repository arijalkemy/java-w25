package org.abstractFactoryPattern;

import org.abstractFactoryPattern.factory.FactoryProvider;
import org.abstractFactoryPattern.repository.AbstractFactory;
import org.abstractFactoryPattern.repository.Card;
import org.abstractFactoryPattern.repository.PaymentMethod;

public class Main {
    public static void main(String[] args) {
        testAbstractFactory();
    }

    public static void testAbstractFactory(){
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        Card chosenCard = (Card) abstractFactory.create("VISA");

        AbstractFactory abstractFactory2 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod chosenPaymentMethod = (PaymentMethod) abstractFactory2.create("DEBIT");

        System.out.println("Tarjeta elegida es: " + chosenCard.getCardType() + " con el metodo de pago: " + chosenPaymentMethod.doPayment());
    }
}

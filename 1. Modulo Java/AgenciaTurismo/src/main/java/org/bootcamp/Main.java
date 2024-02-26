package org.bootcamp;

import org.bootcamp.Repository.ClientRepository;
import org.bootcamp.Repository.LocatorRepository;
import org.bootcamp.model.*;

import java.util.List;

public class Main {


    public static void main (String[] args){
        final LocatorRepository locatorRepository = new LocatorRepository();
        final ClientRepository clientRepository = new ClientRepository();
        HandlerLocator handlerLocator = new HandlerLocator(locatorRepository);

        Client client1 = clientRepository.getClient(new Client(1,"Emma"));


        //Descuento por paquete completo
        Locator locator1 =
                new Locator(
                        client1,
                        List.of(new Hotel(11,200),
                                new Food(12,50),
                                new Transport(13,100),
                                new TravelTicket(14,400)),
                        locatorRepository);

        locatorRepository.addLocator(locator1);

        Locator locator2 = new Locator(
                client1,
                List.of(new Hotel(21,200),
                        new Hotel(22,200),
                        new TravelTicket(23,400),
                        new TravelTicket(24,400),
                        new Food(14,100)),
                locatorRepository);

        locatorRepository.addLocator(locator2);

        Locator locator3 = new Locator(
                client1,
                List.of(new Hotel(21,100)),
                locatorRepository);

        locatorRepository.addLocator(locator3);

        System.out.println("Total lcoalizadores: " + handlerLocator.getSoldLocators());
        System.out.println("Total de reservas: " + handlerLocator.getTotalReservations());
        System.out.println("Total de ventas: $" + handlerLocator.getTotalSales());
        System.out.println("Promedio de venta: $" + handlerLocator.getSalesAverage());
        System.out.println(handlerLocator.getReservationsDictionary());

    }
}
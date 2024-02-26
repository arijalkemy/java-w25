package org.bootcamp.model;

import org.bootcamp.Repository.LocatorRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HandlerLocator {
    private LocatorRepository locatorRepository;
    private HashMap<Class, List<Reservation>> reservationsDictionary;

    public HandlerLocator(LocatorRepository locatorRepository) {
        this.locatorRepository = locatorRepository;
    }

    public int getSoldLocators(){
        return this.locatorRepository.getLocatorList().size();
    }
    public int getTotalReservations(){
        return this.locatorRepository.getLocatorList().stream().mapToInt(l->l.getReservationList().size()).sum();
    }
    public double getTotalSales(){
        return this.locatorRepository.getLocatorList().stream().mapToDouble(Locator::getTotalWithDiscount).sum();
    }
    public double getSalesAverage(){
        return this.locatorRepository.getLocatorList().stream().mapToDouble(Locator::getTotalWithDiscount).average().getAsDouble();
    }

    public HashMap<Class,List<Reservation>> getReservationsDictionary(){
        List<Reservation> hotelList = new ArrayList();
        List<Reservation> foodList = new ArrayList();
        List<Reservation> transportList = new ArrayList();
        List<Reservation> travelTicketList = new ArrayList();
        this.locatorRepository.getLocatorList().forEach(l->l.getReservationList().forEach(r->{
            if(r instanceof Hotel)
                hotelList.add(r);
            if(r instanceof Food)
                foodList.add(r);
            if(r instanceof Transport)
                transportList.add(r);
            if(r instanceof TravelTicket)
                travelTicketList.add(r);
        }));
        return reservationsDictionary = new HashMap<>(){
            {
                put(Hotel.class,hotelList);
                put(Food.class,foodList);
                put(Transport.class,transportList);
                put(TravelTicket.class,travelTicketList);
            }
        };

    }
}

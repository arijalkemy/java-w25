package org.bootcamp.model;

import org.bootcamp.Repository.LocatorRepository;

import java.util.ArrayList;
import java.util.List;

public class Locator {
    private Client client;
    private double total;
    private double totalWithDiscount;
    private List<Reservation> reservationList;
    private LocatorRepository locatorRepository;

    public Locator(Client client, List<Reservation> reservationList, LocatorRepository locatorRepository) {
        this.client = client;
        this.reservationList = reservationList;
        this.locatorRepository = locatorRepository;
        this.total = getTotalLocator();
        this.totalWithDiscount = validateDiscount();
    }
    private double validateDiscount(){
        double totalWithDiscount = this.total;
        //Descuento por reserva 5% si 2 reservas de hotel o 2 de boletosViaje
        List<Reservation> reservationListTemp = validateTwoReservation();
        if(!reservationListTemp.isEmpty()){
            double discount =  reservationListTemp.stream().mapToDouble(r->{r.setDiscount(r.getPrice()*0.05); return r.getDiscount();}).sum();
            totalWithDiscount = total - discount;
        }
        //Descuento por adquirir 2 localizadores 5% en el total
        if(locatorRepository.getLocatorByClient(client.getIdClient()).size()>1){
            totalWithDiscount = total*0.95;
        }
        //Descuento por paquete completo 10% en el total
        if(validateCompletePackage()){
            totalWithDiscount = total*0.9;
        }
        return totalWithDiscount;
    }
    public double getTotalLocator() { return reservationList.stream().mapToDouble(Reservation::getPrice).sum();}
    private List<Reservation> validateTwoReservation(){
        int hotelReservation = 0;
        int travelTicketReservation = 0;

        for(Reservation reservation : reservationList){
            if(reservation instanceof Hotel)
                hotelReservation++;
            if(reservation instanceof TravelTicket)
                travelTicketReservation++;
        }
        if(hotelReservation>1&&travelTicketReservation>1)
            return reservationList.stream().filter(r->r instanceof Hotel || r instanceof TravelTicket).toList();
        if(hotelReservation>1)
            return reservationList.stream().filter(r->r instanceof Hotel).toList();
        if(travelTicketReservation>1)
            return reservationList.stream().filter(r->r instanceof TravelTicket).toList();

        return new ArrayList<>();
    }
    private boolean validateCompletePackage(){
        boolean hotelReservation = false;
        boolean foodReservation = false;
        boolean travelTicketReservation = false;
        boolean transportReservation = false;
        for(Reservation reservation : reservationList){
            if(reservation instanceof Hotel)
                hotelReservation = true;
            if(reservation instanceof Food)
                foodReservation = true;
            if(reservation instanceof TravelTicket)
                travelTicketReservation = true;
            if(reservation instanceof Transport)
                transportReservation = true;
        }
        return (hotelReservation&&foodReservation&&transportReservation&&travelTicketReservation);
    }

    @Override
    public String toString() {
        return "Locator{\n" +
                "client=" + client +
                "\n, reservationList=" + reservationList +
                "\n, total=" + total +
                "\n, totalWithDiscount=" + totalWithDiscount +
                '}';
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }


    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public double getTotalWithDiscount() {
        return totalWithDiscount;
    }
}

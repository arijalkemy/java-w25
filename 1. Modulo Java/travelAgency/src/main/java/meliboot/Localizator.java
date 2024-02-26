package meliboot;

import java.util.List;

public class Localizator {
    private  Client client;
    private  String discount;
    private AdditionalServices additionalServices;
    List<Reservation> reservations;

    public Localizator(Client client,
                       AdditionalServices additionalServices,
                       List<Reservation> reservations) {
        this.client = client;
        this.additionalServices = additionalServices;
        this.reservations = reservations;
    }

    private String getDiscount(){
        StringBuilder discountMessage = new StringBuilder("Descuentos obtenidos: \n");
        if(LocalizatorRepository
                .getInstance()
                .getAll()
                .stream()
                .filter(localizator -> localizator.client.getId() == this.client.getId())
                .count() > 0) discountMessage
                .append("5% de descuento por adquirir previamente al menos 2 localizadores\n");
        if(this.reservations.size() > 0
                && this.additionalServices.getFoodTicketsAmount() > 0
                && this.additionalServices.getTravelTicketsAmount() > 0
                && this.additionalServices.getTransportTicketAmount() > 0
        ) discountMessage.append("10% de descuento por adquirir tu paquete completo\n");
        if(this.reservations.size() == 2 || this.additionalServices.getTravelTicketsAmount() == 2)
            discountMessage.append("5% de descuento por adquirir 2 reservas de hotel o 2 reservas de viaje\n");

        return discountMessage.toString();
    }

    @Override
    public String toString(){
        return getDiscount();
    }
}


package bootcamp.domain.booking;

import bootcamp.Main;

public class BookingBase implements Booking {

    public BookingBase() {}

    @Override
    public Double getPrice() {
        return 0.0;
    }

    @Override
    public String getKey() {
        return "Reserva con: ";
    }

    @Override
    public String getKeyWithPrice() {
        return getKey();
    }

    @Override
    public String toString() {
        return getKeyWithPrice();
    }

    @Override
    public Double getFoodPrice() {
        return 0.0;
    }

    @Override
    public Double getHotelPrice() {
        return 0.0;
    }

    @Override
    public Double getTicketsPrice() {
        return 0.0;
    }

    @Override
    public Double getTransportPrice() {
        return 0.0;
    }

}

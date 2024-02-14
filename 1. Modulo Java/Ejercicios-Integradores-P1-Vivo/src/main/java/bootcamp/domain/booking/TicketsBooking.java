package bootcamp.domain.booking;

import bootcamp.Main;

public class TicketsBooking implements Booking {
    private final Booking booking;
    private final Double price;

    public TicketsBooking(double price) {
        this.booking = new BookingBase();
        this.price = price;
    }
    public TicketsBooking(Booking booking, double price) {
        this.booking = booking;
        this.price = price;
    }

    @Override
    public String getKey() {
        return booking.getKey() + Main.ticketsBooking();
    }

    @Override
    public String getKeyWithPrice() {
        return booking.getKey() + Main.ticketsBooking() + "($" + price + ")";
    }

    @Override
    public String toString() {
        return getKeyWithPrice();
    }

    @Override
    public Double getPrice() {
        return booking.getPrice() + price;
    }

    @Override
    public Double getFoodPrice() {
        return booking.getFoodPrice();
    }

    @Override
    public Double getHotelPrice() {
        return booking.getHotelPrice();
    }

    @Override
    public Double getTicketsPrice() {
        return price;
    }

    @Override
    public Double getTransportPrice() {
        return booking.getTransportPrice();
    }
}

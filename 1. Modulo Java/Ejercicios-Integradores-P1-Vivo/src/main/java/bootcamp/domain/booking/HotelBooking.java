package bootcamp.domain.booking;

import bootcamp.Main;

public class HotelBooking implements Booking {
    private final Booking booking;
    private final Double price;

    public HotelBooking(double price) {
        this.booking = new BookingBase();
        this.price = price;
    }
    public HotelBooking(Booking booking, double price) {
        this.booking = booking;
        this.price = price;
    }

    @Override
    public String getKey() {
        return booking.getKey() + Main.hotelBooking();
    }

    @Override
    public String getKeyWithPrice() {
        return booking.getKey() + Main.hotelBooking() + "($" + price + ")";
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
        return price;
    }

    @Override
    public Double getTicketsPrice() {
        return booking.getTicketsPrice();
    }

    @Override
    public Double getTransportPrice() {
        return booking.getTransportPrice();
    }

}

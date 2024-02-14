package bootcamp.domain.booking;

import bootcamp.Main;

public class FoodBooking implements Booking {
    private final Booking booking;
    private final Double price;

    public FoodBooking(double price) {
        this.booking = new BookingBase();
        this.price = price;
    }

    public FoodBooking(Booking booking, double price) {
        this.booking = booking;
        this.price = price;
    }

    @Override
    public String getKey() {
        return booking.getKey() + Main.foodBooking();
    }

    @Override
    public String getKeyWithPrice() {
        return booking.getKey() + Main.foodBooking() + "($" + price + ")";
    }

    @Override
    public String toString() {
        return getKeyWithPrice();
    }

    public Double getPrice() {
        return booking.getPrice() + price;
    }

    @Override
    public Double getFoodPrice() {
        return price;
    }

    @Override
    public Double getHotelPrice() {
        return booking.getHotelPrice();
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

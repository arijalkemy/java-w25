package bootcamp.domain;

import bootcamp.Main;
import bootcamp.domain.booking.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Tracker extends GenericObject {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private List<Booking> bookings;
    private Client client;

    public Tracker(Client client) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.bookings = new ArrayList<>();
        this.client = client;
    }

    public Tracker(List<Booking> bookings, Client client) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.bookings = bookings;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Tracker{" +
                "bookings=" + bookings +
                ", client=" + client +
                ", total=" + getTotal() +
                '}';
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getTotal() {
        return bookings.stream().map(Booking::getPrice).reduce(0.0, Double::sum);
    }

    public void addCompleteBooking(double hotelPrice, double foodPrice, double ticketsPrice, double transportPrice) {
        bookings.add(new FoodBooking(new HotelBooking(new TicketsBooking(new TransportBooking(new BookingBase(), transportPrice), ticketsPrice), hotelPrice), foodPrice));
    }

    public boolean hasCompleteTouristPackage(){
        return bookings.stream().anyMatch(b ->
                b.getKey().contains(Main.foodBooking())
                && b.getKey().contains(Main.hotelBooking())
                && b.getKey().contains(Main.ticketsBooking())
                && b.getKey().contains(Main.transportBooking())
        );
    }
}

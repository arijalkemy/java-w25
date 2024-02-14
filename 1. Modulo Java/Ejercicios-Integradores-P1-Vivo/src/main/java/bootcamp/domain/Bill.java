package bootcamp.domain;

import bootcamp.domain.booking.BookingBase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bill extends GenericObject {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private Client client;
    private List<BookingBase> bookings;

    public Bill(Client client) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.client = client;
        this.bookings = new ArrayList<>();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<BookingBase> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingBase> bookings) {
        this.bookings = bookings;
    }

    public double getTotal() {
        return 0;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", client=" + client +
                ", bookings=" + bookings +
                '}';
    }
}

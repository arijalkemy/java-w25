package entity;

public class Ticket extends Reservation{
    public Ticket(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + getPrice() +
                '}';    }
}

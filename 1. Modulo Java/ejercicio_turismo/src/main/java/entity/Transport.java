package entity;

public class Transport extends Reservation{
    public Transport(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "price=" + getPrice() +
                '}';
    }
}

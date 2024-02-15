package entity;

public class Hotel extends Reservation{
    public Hotel(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "price=" + getPrice() +
                '}';
    }
}

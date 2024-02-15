package entity;

public class Reservation {
    private double price;

    public Reservation(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "price=" + price +
                '}';
    }
}

package entity;

public class Food extends Reservation{

    public Food(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Food{" +
                "price=" + getPrice() +
                '}';
    }
}

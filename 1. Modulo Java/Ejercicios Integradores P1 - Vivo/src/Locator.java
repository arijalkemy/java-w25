import java.util.ArrayList;
import java.util.List;

public class Locator {
    Client client;
    List<Reservation> reservations = new ArrayList<>();
    double totalWithDiscount;
    double totalWithoutDiscount;

    public Locator(Client client){
        this.client = client;
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
        calculateTotals();
    }

    private void calculateTotals() {
        totalWithoutDiscount = reservations.stream().mapToDouble(Reservation::price).sum();
        totalWithDiscount = applyDiscount();
    }

    private double applyDiscount() {
        double discount = 0.0;
        if (reservations.size() >= 4) {
            discount = 0.10;
        } else if (client.locators.size() >= 2) {
            discount = 0.05;
        }
        return totalWithoutDiscount - (totalWithoutDiscount * discount);
    }

    @Override
    public String toString() {
        return "Locator{" +
                "client=" + client +
                ", reservations=" + reservations +
                ", totalWithDiscount=" + totalWithDiscount +
                ", totalWithoutDiscount=" + totalWithoutDiscount +
                '}';
    }
}

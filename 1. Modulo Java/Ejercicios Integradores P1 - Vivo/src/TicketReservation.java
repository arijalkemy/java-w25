public class TicketReservation implements Reservation{
    private double price;

    public TicketReservation(double price){
        this.price = price;
    }
    @Override
    public double price() {
        return price;
    }

    @Override
    public String type() {
        return "Ticket";
    }

    @Override
    public String toString() {
        return "TicketReservation{" +
                "price=" + price +
                '}';
    }
}

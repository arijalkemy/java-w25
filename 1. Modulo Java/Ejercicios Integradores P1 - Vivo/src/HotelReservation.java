public class HotelReservation implements Reservation{
    private double price;

    public HotelReservation(double price){
        this.price = price;
    }
    @Override
    public double price() {
        return price;
    }

    @Override
    public String type() {
        return "Hotel";
    }

    @Override
    public String toString() {
        return "HotelReservation{" +
                "price=" + price +
                '}';
    }
}

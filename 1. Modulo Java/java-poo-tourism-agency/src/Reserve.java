public class Reserve {
    private ReserveType reserveType;
    private double price;

    public Reserve(ReserveType reserveType, double price) {
        this.reserveType = reserveType;
        this.price = price;
    }

    public ReserveType getReserveType() {
        return reserveType;
    }

    public void setReserveType(ReserveType reserveType) {
        this.reserveType = reserveType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "reserveType=" + reserveType +
                ", price=" + price +
                '}';
    }
}

package bootcamp.domain.booking;

public interface Booking {

    String getKey();

    String getKeyWithPrice();

    Double getPrice();

    Double getFoodPrice();

    Double getHotelPrice();

    Double getTicketsPrice();

    Double getTransportPrice();

}

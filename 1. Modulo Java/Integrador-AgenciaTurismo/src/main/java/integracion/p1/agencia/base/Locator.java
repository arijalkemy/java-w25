package integracion.p1.agencia.base;

import lombok.Data;

import java.util.List;

@Data
public class Locator {
    final  double FLY_HOTEL_DISCOUNT= 0.05;
    final double ALL_INCLUDE_DISCOUNT=0.1;

    private Client client;
    private List<Booking> bookingList;
    private double price;

    public Locator(Client client, List<Booking> bookingList){
        this.client= client;
        this.bookingList = bookingList;
        setPriceFromList();
    }

    private void setPriceFromList(){
        applyDiscountToHotelAndFligth();
        this.price = bookingList.stream().mapToDouble(Booking::getPrice).sum();

        if (isAllInclude()){
            System.out.println("apply all include " );
            this.price = this.price - (this.price * ALL_INCLUDE_DISCOUNT);
        }
    }

    private void applyDiscountToHotelAndFligth(){
        if (bookingList.stream().filter(x-> x.getIdBooking()==1).count() >1){
            System.out.println(" apply 2 Hotel discount " );
            bookingList.stream().filter(x-> x.getIdBooking()==1).forEach(x-> {
                double price = x.getPrice() - (x.getPrice()* FLY_HOTEL_DISCOUNT);
                x.setPrice(price);
            });
        }
        if (bookingList.stream().filter(x-> x.getIdBooking()==3).count() >1){
            System.out.println(" apply 2 flights discount " );
            bookingList.stream().filter(x-> x.getIdBooking()==3).forEach(x-> {
                double price = x.getPrice() - (x.getPrice()* FLY_HOTEL_DISCOUNT);
                x.setPrice(price);
            });
        }
    }

    public boolean isAllInclude(){
        return bookingList.stream().distinct().count() > 3;
    }


    @Override
    public String toString() {
        return "Locator{" +
                ", client=" + client +
                ", bookingList=" + bookingList +
                ", price=" + price +
                '}';
    }
}

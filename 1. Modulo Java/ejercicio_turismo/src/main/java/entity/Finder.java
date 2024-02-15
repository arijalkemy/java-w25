package entity;

import repository.FinderRepository;

import java.util.List;
import java.util.Objects;

public class Finder {
    private Client client;
    private double totalAmount;
    private List<Reservation> reservationList;

    public Finder(Client client, List<Reservation> reservationList) {
        this.client = client;
        this.reservationList = reservationList;
        this.calculateTotalAmount();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "Finder{" +
                "client=" + client +
                ", totalAmount=" + totalAmount +
                ", reservationList=" + reservationList +
                '}';
    }

    private void calculateTotalAmount() {
        double baseAmount = this.reservationList.stream().mapToDouble(Reservation::getPrice).sum();
        double discount = 1;

        long previousFinders = FinderRepository.finderList.stream().filter(finder -> Objects.equals(finder.getClient(), this.client)).count();

        if (previousFinders >= 2) {
            System.out.println("Descuento del 5% aplicado, monto original: " + baseAmount);
            discount = discount - 0.05;
        }

        if (this.reservationList.stream().anyMatch(reservation -> reservation instanceof Food)
                && this.reservationList.stream().anyMatch(reservation -> reservation instanceof Hotel)
                && this.reservationList.stream().anyMatch(reservation -> reservation instanceof Ticket)
                && this.reservationList.stream().anyMatch(reservation -> reservation instanceof Transport)) {
            System.out.println("Descuento del 10% aplicado, monto original: " + baseAmount);
            discount = discount - 0.01;
        }

        List<Reservation> hotelReservations = this.reservationList.stream().filter(reservation -> reservation instanceof Hotel).toList();
        List<Reservation> ticketReservations = this.reservationList.stream().filter(reservation -> reservation instanceof Ticket).toList();

        if (hotelReservations.size() >= 2) {
            System.out.println("Descuento del 5% aplicado en las reservas de hotel");
            hotelReservations.forEach(reservation -> reservation.setPrice(reservation.getPrice() * 0.95));
        }

        if (ticketReservations.size() >= 2) {
            System.out.println("Descuento del 5% aplicado en las reservas de boletos");
            ticketReservations.forEach(reservation -> reservation.setPrice(reservation.getPrice() * 0.95));
        }

        this.totalAmount = baseAmount * discount;

    }
}

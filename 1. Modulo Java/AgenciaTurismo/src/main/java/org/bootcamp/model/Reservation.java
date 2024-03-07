package org.bootcamp.model;

public abstract class Reservation {
    private int idReservation;
    private double price;
    private double discount;

    public Reservation(int idReservation, double price) {
        this.idReservation = idReservation;
        this.price = price;
        this.discount = 0.0;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", price=" + price +
                ", discount=" + discount +
                "}\n";
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

package bootcamp.service;

import bootcamp.domain.booking.Booking;

import java.util.List;
import java.util.Map;

public interface ITrackerService {

    int getAmountOfTrackersSold();

    int getAmountOfBookings();

    Map<String, List<Booking>> getBookingsByType();

    double getTotalOfSales();

    double getAvgOfSales();

    void calculateDiscountsAndShowResults();

}

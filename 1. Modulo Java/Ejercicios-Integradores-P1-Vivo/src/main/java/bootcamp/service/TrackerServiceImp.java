package bootcamp.service;

import bootcamp.Main;
import bootcamp.domain.*;
import bootcamp.domain.booking.*;
import bootcamp.repository.IGenericRepository;

import java.util.*;
import java.util.stream.Collectors;

public class TrackerServiceImp implements ITrackerService {
    private final IGenericRepository<Client> clientRepository;
    private final IGenericRepository<Tracker> trackerRepository;

    static final double twoTrackersDiscount = 0.05;
    static final double completePackageDiscount = 0.1;
    static final double twoBookingsDiscount = 0.05;

    public TrackerServiceImp(IGenericRepository<Client> clientRepository, IGenericRepository<Tracker> trackerRepository) {
        this.clientRepository = clientRepository;
        this.trackerRepository = trackerRepository;
    }

    @Override
    public int getAmountOfTrackersSold() {
        return trackerRepository.findAll().size();
    }

    @Override
    public int getAmountOfBookings() {
        return trackerRepository.findAll().stream().map(t -> t.getBookings().stream().map(this::getAmountOfBookingsPerBooking).collect(Collectors.toList()).stream().reduce(0, Integer::sum)).reduce(0, Integer::sum);
    }

    private Integer getAmountOfBookingsPerBooking(Booking booking) {
        int totalBookings = 0;
        String key = booking.getKey();

        if (key.contains(Main.foodBooking())) totalBookings += 1;
        if (key.contains(Main.hotelBooking())) totalBookings += 1;
        if (key.contains(Main.ticketsBooking())) totalBookings += 1;
        if (key.contains(Main.transportBooking())) totalBookings += 1;

        return totalBookings;
    }

    @Override
    public Map<String, List<Booking>> getBookingsByType() {
        List<Booking> bookings = trackerRepository.findAll().stream().flatMap(a -> a.getBookings().stream()).collect(Collectors.toList());
        Map<String, List<Booking>> bookingsByType = new HashMap<>();
        for (Booking booking : bookings) {
            List<Booking> individualBookings = new ArrayList<>();
            if (booking.getHotelPrice() > 0) individualBookings.add(new HotelBooking(booking.getHotelPrice()));
            if (booking.getFoodPrice() > 0) individualBookings.add(new FoodBooking(booking.getFoodPrice()));
            if (booking.getTicketsPrice() > 0) individualBookings.add(new TicketsBooking(booking.getTicketsPrice()));
            if (booking.getTransportPrice() > 0) individualBookings.add(new TransportBooking(booking.getTransportPrice()));
            for (Booking individualBooking : individualBookings) {
                String key = individualBooking.getKey();
                if (!bookingsByType.containsKey(key)) bookingsByType.put(key, Collections.singletonList(individualBooking));
                else {
                    List<Booking> listOfBookings = new ArrayList<>(bookingsByType.get(key));
                    listOfBookings.add(individualBooking);
                    bookingsByType.put(key, listOfBookings);
                }
            }
        }
        return bookingsByType;
    }

    @Override
    public double getTotalOfSales() {
        return trackerRepository.findAll().stream()
                .map(Tracker::getTotal)
                .reduce(0.0, Double::sum);
    }

    @Override
    public double getAvgOfSales() {
        return getTotalOfSales() / getAmountOfTrackersSold();
    }

    public void calculateDiscountsAndShowResults() {
        for (Client client : clientRepository.findAll()){
            int clientId = client.getId();
            List<Tracker> trackersOfClient = trackerRepository.findAll().stream().filter(t -> t.getClient().getId() == clientId).collect(Collectors.toList());
            double initialTotal = trackersOfClient.stream().map(Tracker::getTotal).reduce(0.0, Double::sum);
            double clientTwoTrackersDiscount = getTwoTrackersDiscount(trackersOfClient);
            double clientCompletePackageDiscount = getCompletePackageDiscount(trackersOfClient, initialTotal);
            double clientTwoBookingsDiscount = getTwoBookingsDiscount(trackersOfClient, initialTotal);
            System.out.println("Descuento de 2 localizadores: $" + clientTwoTrackersDiscount);
            System.out.println("Descuento de paquete completo: $" + clientCompletePackageDiscount);
            System.out.println("Descuento de 2 reservas: $" + clientTwoBookingsDiscount);
            double total = initialTotal - clientTwoTrackersDiscount - clientCompletePackageDiscount - clientTwoBookingsDiscount;
            System.out.println("Del total inicial $" + initialTotal + " para el cliente '" + client.getFirstName() + " " + client.getLastName() + "', le queda pagar: $" + total);
        }
    }

    private double getTwoTrackersDiscount(List<Tracker> trackersOfClient) {
        boolean hasTwoTrackersDiscount = trackersOfClient.size() >= 2;
        if (!hasTwoTrackersDiscount) return 0;
        double totalTrackersToDiscount = trackersOfClient.subList(2, trackersOfClient.size()).stream().map(Tracker::getTotal).reduce(Double::sum).orElse(0.0);
        return totalTrackersToDiscount * twoTrackersDiscount;
    }

    private double getCompletePackageDiscount(List<Tracker> trackersOfClient, double initialTotal) {
        boolean hasCompletePackageDiscount = false;
        for (Tracker trackerOfClient : trackersOfClient) {
            if (trackerOfClient.hasCompleteTouristPackage()) {
                hasCompletePackageDiscount = true;
                break;
            }
        }
        if (hasCompletePackageDiscount) return initialTotal * completePackageDiscount;
        return 0.0;
    }

    private double getTwoBookingsDiscount(List<Tracker> trackersOfClient, double initialTotal) {
        double totalDiscount = 0.0;
        int amountHotelBookings = 0;
        int amountTicketsBookings = 0;

        for (Tracker tracker : trackersOfClient){
            for (Booking booking : tracker.getBookings()){
                if (booking.getKey().contains(Main.hotelBooking())) {
                    amountHotelBookings++;
                    totalDiscount += booking.getHotelPrice() * twoBookingsDiscount;
                }
                if (booking.getKey().contains(Main.ticketsBooking())) {
                    amountTicketsBookings++;
                    totalDiscount += booking.getTicketsPrice() * twoBookingsDiscount;
                }
            }
        }

        boolean hasTwoBookingsDiscount = amountHotelBookings >= 2 || amountTicketsBookings >= 2;
        if (hasTwoBookingsDiscount) return totalDiscount;
        return 0.0;
    }

}

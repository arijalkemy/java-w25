package entity;

import repository.FinderRepository;

import java.util.HashMap;
import java.util.List;

public class Report {

    public static int getTotalFinders(){
        return FinderRepository.finderList.size();
    }

    public static long getTotalReservations(){
        List<Reservation> reservationList = FinderRepository.finderList.stream().flatMap(finder -> finder.getReservationList().stream()).toList();

        return reservationList.size();
    }

public static HashMap<String, Long> getDictionary(){
    HashMap<String, Long> dictionary = new HashMap<String, Long>();

    List<Reservation> reservationList = FinderRepository.finderList.stream().flatMap(finder -> finder.getReservationList().stream()).toList();

    dictionary.put("Food", reservationList.stream().filter(reservation -> reservation instanceof Food).count());
    dictionary.put("Hotel", reservationList.stream().filter(reservation -> reservation instanceof Hotel).count());
    dictionary.put("Ticket", reservationList.stream().filter(reservation -> reservation instanceof Ticket).count());
    dictionary.put("Transport", reservationList.stream().filter(reservation -> reservation instanceof Transport).count());

    return dictionary;
}

public static double getTotalSales(){
    return FinderRepository.finderList.stream().mapToDouble(Finder::getTotalAmount).sum();
}

    public static double avgSales(){
        return FinderRepository.finderList.stream().mapToDouble(Finder::getTotalAmount).sum() / FinderRepository.finderList.size();
    }
}

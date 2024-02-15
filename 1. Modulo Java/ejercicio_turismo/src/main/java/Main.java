import entity.*;
import repository.FinderRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client client1 = new Client(1);

        List<Reservation> touristPackage1 = new ArrayList<>();

        touristPackage1.add(new Food(25.56));
        touristPackage1.add(new Hotel(123));
        touristPackage1.add(new Ticket(4));
        touristPackage1.add(new Transport(10));

        Finder finder1 = new Finder(client1, touristPackage1);

        FinderRepository.finderList.add(finder1);
        System.out.println(finder1.toString());

        List<Reservation> touristPackage2 = new ArrayList<>();
        touristPackage2.add(new Hotel(50));
        touristPackage2.add(new Hotel(123));
        touristPackage2.add(new Ticket(4));
        touristPackage2.add(new Ticket(10));

        Finder finder2 = new Finder(client1, touristPackage2);

        FinderRepository.finderList.add(finder2);
        System.out.println(finder2.toString());

        List<Reservation> touristPackage3 = new ArrayList<>();
        touristPackage3.add(new Hotel(25.56));

        Finder finder3 = new Finder(client1, touristPackage3);

        FinderRepository.finderList.add(finder3);
        System.out.println(finder3.toString());

        System.out.println("Localizadores totales: " + Report.getTotalFinders());
        System.out.println("Reservas totales: " + Report.getTotalReservations());
        System.out.println("Diccionario");
        System.out.println(Collections.singleton(Report.getDictionary()));
        System.out.println("Ventas totales: " + Report.getTotalSales());
        System.out.println("Promedio de ventas: " + Report.avgSales());


    }

}

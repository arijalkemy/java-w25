package integracion.p1.agencia;

import integracion.p1.agencia.base.Booking;
import integracion.p1.agencia.base.Client;
import integracion.p1.agencia.base.Locator;
import integracion.p1.agencia.repo.ClientRepo;
import integracion.p1.agencia.repo.LocatorRepo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        ClientRepo repoClient = new ClientRepo();
        repoClient.addClient(new Client(1234,"Cross1","34333434"));
        repoClient.addClient(new Client(1235,"Cross2","34333434"));
        repoClient.addClient(new Client(1236,"Cross3","34333434"));
        repoClient.addClient(new Client(1237,"Cross4","34333434"));

        LocatorRepo repoLocator = new LocatorRepo();
        Locator aux ;

        aux =  repoLocator.addLocator(new Locator(repoClient.findByDni(1234),
                getNewBookingList(new int[]{1, 2})
        ));
        System.out.println("repoLocator = " + aux);

        //add two hotels but only one fly It must be a discount  only  in hotel
        System.out.println(" -------");
        aux = repoLocator.addLocator(new Locator(repoClient.findByDni(1234),getNewBookingList(new int[]{1, 3,1,3})));
        System.out.println("repoLocator = " + aux);

        //all include
        System.out.println(" -------");
        aux = repoLocator.addLocator(new Locator(repoClient.findByDni(1236),getNewBookingList(new int[]{1, 2,3,4})));
        System.out.println("repoLocator = " + aux);

        //all include
        System.out.println(" -------");
        aux = repoLocator.addLocator(new Locator(repoClient.findByDni(1234),getNewBookingList(new int[]{1,3,1,3,2,4})));
        System.out.println("repoLocator = " + aux);

        System.out.println(" Locator sold= " + repoLocator.countLocatorSold());
        System.out.println(" Toral bookings = " + repoLocator.countBooking());
        System.out.println(" Total sells = " + repoLocator.totalSells());
        System.out.println(" Average sells = " + repoLocator.avgSells());

    }

    private static Booking getNewBooking(int id){
        Booking booking;
        switch (id){
            case 1 -> {
                return new Booking(1,"Hotel",1000);
            }
            case 2-> {
                return new Booking(2, "Food", 200);
            }
            case 3-> {
                return new Booking(3, "Fligth", 3000);
            }
            case 4-> {
                return new Booking(4, "Transport", 800);
            }default -> {
                return new Booking(1,"Hotel",1000);
            }
        }
    }

    private static List<Booking> getNewBookingList(int[] bookingID){
        List<Booking> newBookingList = new ArrayList<>();
        for (int id : bookingID){
            newBookingList.add(getNewBooking(id));
        }
        return  newBookingList;
    }
}

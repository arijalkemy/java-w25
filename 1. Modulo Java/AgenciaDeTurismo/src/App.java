import java.util.Arrays;

import models.Client;
import models.Food;
import models.Hotel;
import models.Product;
import models.Repository;
import models.Transport;
import models.TravelTicket;

public class App {
    public static void main(String[] args) throws Exception {
        Client client1 = new Client(1L, "Ricardo", "Electrico");
        Product hotel1 = new Hotel(1L, "Hotel 5 estrellas", 3000D);
        Product hotel2 = new Hotel(2L, "Hotel 4 estrellas", 2000D);
        Product ticket1 = new TravelTicket(3L, "Voleto de avion", 5000D);
        Product ticket2 = new TravelTicket(4L, "Voleto de combi", 1000D);
        Product transport1 = new Transport(5L, "Transporte premium", 1000D);
        Product transport2 = new Transport(6L, "Transporte regular", 500D);
        Product food1 = new Food(7L, "Pension completa", 500D);
        Product food2 = new Food(8L, "Media pension", 250D);

        Repository.addLocator(client1.buyProduct(Arrays.asList(hotel1,ticket1,transport1,food1)));
        Repository.addLocator(client1.buyProduct(Arrays.asList(hotel1, hotel2,ticket1,ticket2)));
        Repository.addLocator(client1.buyProduct(Arrays.asList(transport2,food2)));

        System.out.println("Localizadores vendidos: "+Repository.locatorsSold());
        System.out.println("Total de reservas: "+Repository.totalBookings());
        System.out.println(Repository.totalClasifiedBookings());
        System.out.println("Total recaudado en ventas: $"+Repository.totalSold());
        System.out.println("Promedio de ventas: $"+Repository.averageSold());
    }
}

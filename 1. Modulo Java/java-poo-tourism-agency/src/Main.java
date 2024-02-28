import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Samuel", "Villegas");
        Locator locator = new Locator(
                client,
                List.of(
                    new Reserve(ReserveType.FOOD, 1000),
                    new Reserve(ReserveType.HOTEL, 1000),
                    new Reserve(ReserveType.TICKETS, 1000),
                    new Reserve(ReserveType.TRANSPORT, 1000)
                )
        );
        LocatorRepository.addLocator(locator);
        System.out.println(LocatorRepository.getLocators());
        Locator locator2 = new Locator(
                client,
                List.of(
                        new Reserve(ReserveType.HOTEL, 1000),
                        new Reserve(ReserveType.HOTEL, 1000),
                        new Reserve(ReserveType.TICKETS, 1000),
                        new Reserve(ReserveType.TICKETS, 1000)
                )
        );
        LocatorRepository.addLocator(locator2);
        System.out.println(LocatorRepository.getLocators());
        Locator locator3 = new Locator(
                client,
                List.of(
                        new Reserve(ReserveType.HOTEL, 1000)
                )
        );
        LocatorRepository.addLocator(locator3);
        System.out.println(LocatorRepository.getLocators());
    }
}
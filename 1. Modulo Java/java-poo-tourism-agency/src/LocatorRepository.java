import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocatorRepository {
    private static final List<Locator> locators = new ArrayList<>();

    public static void addLocator(Locator locator) {
        double totalDiscount = 0;

        Map<ReserveType, List<Reserve>> resultGroupByReserveType = locator.getReserveList().stream().collect(
                Collectors.groupingBy(Reserve::getReserveType)
        );
        System.out.println(resultGroupByReserveType);
        if (
                (resultGroupByReserveType.containsKey(ReserveType.HOTEL) && resultGroupByReserveType.get(ReserveType.HOTEL).size() == 2) ||
                (resultGroupByReserveType.containsKey(ReserveType.TICKETS) && resultGroupByReserveType.get(ReserveType.TICKETS).size() == 2)
        ) {
            for (Reserve reserve : locator.getReserveList()) {
                if (reserve.getReserveType().equals(ReserveType.HOTEL) || reserve.getReserveType().equals(ReserveType.TICKETS)) {
                    reserve.setPrice(reserve.getPrice() * 0.95);
                }
            }
        }

        if (
                resultGroupByReserveType.containsKey(ReserveType.FOOD) &&  !resultGroupByReserveType.get(ReserveType.FOOD).isEmpty() &&
                resultGroupByReserveType.containsKey(ReserveType.HOTEL) &&  !resultGroupByReserveType.get(ReserveType.HOTEL).isEmpty() &&
                resultGroupByReserveType.containsKey(ReserveType.TICKETS) && !resultGroupByReserveType.get(ReserveType.TICKETS).isEmpty() &&
                resultGroupByReserveType.containsKey(ReserveType.TRANSPORT) && !resultGroupByReserveType.get(ReserveType.TRANSPORT).isEmpty()
        ) totalDiscount += 0.1;

        if (locator.getClient().isDiscount())
            totalDiscount += 0.05;
        else if (
                !LocatorRepository.locators.stream().filter((l) -> l.getClient().equals(locator.getClient())).toList().isEmpty()
        ) {
            locator.getClient().setDiscount(true);
        }

        double total = locator.getReserveList().stream().mapToDouble(Reserve::getPrice).sum();
        total *= (1 - totalDiscount);
        locator.setTotal(total);

        if (ClientRepository.getClients().stream().filter((c) -> c.equals(locator.getClient())).toList().isEmpty())
            ClientRepository.addClient(locator.getClient());
        locators.add(locator);
    }

    public static List<Locator> getLocators(){
        return locators;
    }
}

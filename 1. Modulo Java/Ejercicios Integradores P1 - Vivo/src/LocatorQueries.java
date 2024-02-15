import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocatorQueries {
    private List<Locator> locators;

    public LocatorQueries(List<Locator> locators) {
        this.locators = locators;
    }

    public int soldLocatorsCount() {
        return locators.size();
    }

    public long totalReservationsCount() {
        return locators.stream().mapToLong(locator -> locator.reservations.size()).sum();
    }

    public Map<String, Long> reservationsByType() {
        return locators.stream()
                .flatMap(locator -> locator.reservations.stream())
                .collect(Collectors.groupingBy(Reservation::type, Collectors.counting()));
    }

    public double totalSales() {
        return locators.stream().mapToDouble(l -> l.totalWithDiscount).sum();
    }

    public double averageSales() {
        return locators.stream().mapToDouble(l -> l.totalWithDiscount).average().orElse(0);
    }
}

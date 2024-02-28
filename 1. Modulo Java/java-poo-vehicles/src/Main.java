import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = List.of(
                new Vehicle("Fiesta","Ford",1000),
                new Vehicle("Focus","Ford", 1200),
                new Vehicle("Explorer","Ford", 2500),
                new Vehicle("Uno","Fiat", 500),
                new Vehicle("Cronos","Fiat", 1000),
                new Vehicle("Torino","Fiat", 1250),
                new Vehicle("Aveo","Chevrolet",1250),
                new Vehicle("Spin","Chevrolet",2500),
                new Vehicle("Corola", "Toyota",1200),
                new Vehicle("Fortuner", "Toyota",3000),
                new Vehicle("Logan","Renault",950)
        );
        Garage garage = new Garage(1L, vehicles);
        List<Vehicle> vehicleListOrdered = garage.getVehicles().stream()
                .sorted(Comparator.comparing(Vehicle::getPrice))
                .toList();
        System.out.println(vehicleListOrdered);
        List<Vehicle> vehicleListOrderedByBrandAndPrice = garage.getVehicles().stream()
                .sorted(
                        Comparator.comparing(Vehicle::getPrice)
                                .thenComparing(Vehicle::getBrand)
                )
                .toList();
        System.out.println(vehicleListOrderedByBrandAndPrice);

        List<Vehicle> vehiculosMenorMil = garage.getVehicles().stream().filter((vehiculo) -> vehiculo.getPrice() < 1000).collect(Collectors.toList());
        System.out.println(vehiculosMenorMil);

        List<Vehicle> vehiculosMayorIgualMil = garage.getVehicles().stream().filter((vehiculo) -> vehiculo.getPrice() >= 1000).collect(Collectors.toList());
        System.out.println(vehiculosMayorIgualMil);

        double vehiculosPromCostos = garage.getVehicles().stream().mapToDouble(Vehicle::getPrice).average().orElse(0.0);
        System.out.println(vehiculosPromCostos);
    }
}
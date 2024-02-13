import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles= new ArrayList<>();
        Garage garage = new Garage(1, vehicles);
        garage.getVehicles().add(new Vehicle("Fiesta", "Ford", 1000));
        garage.getVehicles().add(new Vehicle("Focus", "Ford", 1200));
        garage.getVehicles().add(new Vehicle("Explorer", "Ford", 2500));
        garage.getVehicles().add(new Vehicle("Uno", "Fiat", 500));
        garage.getVehicles().add(new Vehicle("Cronos", "Fiat", 1000));
        garage.getVehicles().add(new Vehicle("Torino", "Fiat", 1250));
        garage.getVehicles().add(new Vehicle("Aveo", "Chevrolet", 1250));
        garage.getVehicles().add(new Vehicle("Spin", "Chevrolet", 2500));
        garage.getVehicles().add(new Vehicle("Corola", "Toyota", 1200));
        garage.getVehicles().add(new Vehicle("Fortuner", "Toyota", 3000));
        garage.getVehicles().add(new Vehicle("Logan", "Renault", 950));

        System.out.println("Lista de elementos organizada por precio");
        garage.getVehicles().stream()
                .sorted((x,y) -> x.getPrice().compareTo(y.getPrice()))
                .forEach(System.out::println);
        System.out.println("-------------------------");
        System.out.println("Lista de elementos organizada por marca y precio");
        garage.getVehicles().stream()
                .sorted(Comparator.comparing(Vehicle::getMark).thenComparing(Vehicle::getPrice))
                .forEach(System.out::println);
        System.out.println("--------------------------");
        System.out.println("Lista de vehículos con precio no mayor a 1000");
        garage.getVehicles().stream().filter((x) -> x.getPrice() < 1000).forEach(System.out::println);
        System.out.println("Lista de vehículos con precio mayor o igual a 1000");
        garage.getVehicles().stream().filter((x) -> x.getPrice() >= 1000).forEach(System.out::println);
        System.out.println("Promedio total de precios de toda la lista");
        System.out.println(garage.getVehicles().stream().mapToInt(Vehicle::getPrice).average().orElse(0));

    }
}
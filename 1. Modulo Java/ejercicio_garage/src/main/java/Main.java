import entity.Garage;
import entity.Vehicle;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(1);

        garage.getVehicles().add(new Vehicle("Ford", "Fiesta", 1000));
        garage.getVehicles().add(new Vehicle("Ford", "Fiesta", 1100));
        garage.getVehicles().add(new Vehicle("Ford", "Focus", 1200));
        garage.getVehicles().add(new Vehicle("Ford", "Explorer", 1500));
        garage.getVehicles().add(new Vehicle("Fiat", "Uno", 500));
        garage.getVehicles().add(new Vehicle("Fiat", "Cronos", 1000));
        garage.getVehicles().add(new Vehicle("Fiat", "Torino", 1250));
        garage.getVehicles().add(new Vehicle("Chevrolet", "Aveo", 1250));
        garage.getVehicles().add(new Vehicle("Chevrolet", "Spin", 2500));
        garage.getVehicles().add(new Vehicle("Chevrolet", "Spin", 2600));
        garage.getVehicles().add(new Vehicle("Chevrolet", "Spin", 2700));
        garage.getVehicles().add(new Vehicle("Toyota", "Corola", 1200));
        garage.getVehicles().add(new Vehicle("Toyota", "Fortuner", 3000));
        garage.getVehicles().add(new Vehicle("Renault", "Logan", 950));

        garage.getVehicles().sort(
                Comparator.comparing(Vehicle::getCost)
        );

        garage.getVehicles().forEach(System.out::println);

        List<Vehicle> listaOrdenada = garage.getVehicles().stream()
                .sorted(Comparator.comparing(Vehicle::getBrand))
                .sorted(Comparator.comparing(Vehicle::getCost)).toList();

        System.out.println("\nLista ordenada: \n");
        listaOrdenada.forEach(System.out::println);

        List<Vehicle> listaOrdenadaDos = garage.getVehicles().stream()
                .filter(vehiculo -> vehiculo.getCost() < 1000)
                .toList();

        System.out.println("\nLista ordenada 2: \n");
        listaOrdenadaDos.forEach(System.out::println);

        List<Vehicle> listaOrdenadatres = garage.getVehicles().stream()
                .filter(vehiculo -> vehiculo.getCost() >= 1000)
                .toList();

        System.out.println("\nLista ordenada 2: \n");
        listaOrdenadatres.forEach(System.out::println);

        double promedioCosto = garage.getVehicles().stream().mapToInt(Vehicle::getCost).average().getAsDouble();

        System.out.println("\nPromedio: " + promedioCosto);
    }
}

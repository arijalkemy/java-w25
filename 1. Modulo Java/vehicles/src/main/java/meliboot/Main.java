package meliboot;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(1, Arrays.asList(
                new Vehicle("Fiesta","Ford",1000.0),
                new Vehicle("Focus","Ford",1200.0),
                new Vehicle("Explorer","Ford",2500.0),
                new Vehicle("Uno","Fiat",500.0),
                new Vehicle("Fiat","Cronos",1000.0),
                new Vehicle("Fiat","Torino",1250.0),
                new Vehicle("Chevrolet","Spin",2500.0),
                new Vehicle("Chevrolet","Aveo",1250.0),
                new Vehicle("Toyota","Corola",1200.0),
                new Vehicle("Toyota","Fortuner",3000.0),
                new Vehicle("Renault","Logan",950.0)
        ));

        garage.getVehicles()
                .sort(Comparator
                        .comparing(Vehicle::getCost));
        System.out.println("Ordenado por costo");
        for (Vehicle vehicle: garage.getVehicles()){
            System.out.println(vehicle);
        }
        garage.getVehicles()
                .sort(Comparator
                        .comparing(Vehicle::getBrand));
        System.out.println("Ordenado por marca");
        for (Vehicle vehicle: garage.getVehicles()){
            System.out.println(vehicle);
        }
        garage.getVehicles()
                .sort(Comparator
                        .comparing(Vehicle::getModel));
        System.out.println("Ordenado por modelo");
        for (Vehicle vehicle: garage.getVehicles()){
            System.out.println(vehicle);
        }

        List<Vehicle> priceLessOrEqualThanOnThousandDollars = garage
                .getVehicles()
                .stream()
                .filter(vehicle -> vehicle.getCost() <= 1000).toList();
        List<Vehicle> priceUpOrEqualThanOnThousandDollars = garage
                .getVehicles()
                .stream()
                .filter(vehicle -> vehicle.getCost() >= 1000).toList();

        Double average = garage
                .getVehicles()
                .stream()
                .mapToDouble(Vehicle::getCost)
                .average().getAsDouble();
    }
}
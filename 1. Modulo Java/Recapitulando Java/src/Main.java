/*
El objetivo de esta guía práctica es que podamos profundizar el uso de los Generics, haciendo uso en de las
diferentes colecciones de datos y de la Api Stream de java para el manejo de la programación funcional junto con
las expresiones lambda. Para esto vamos a plantear una serie de ejercicios simples e incrementales (ya que vamos a
ir trabajando y agregando lógica a las clases que tenemos que construir), lo que nos permitirá repasar los temas que
estudiamos.
*/

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Garage garage = new Garage(1);
        garage.addVehicle(new Vehicle("Ford", "Fiesta", 1000));
        garage.addVehicle(new Vehicle("Ford", "Focus", 1200));
        garage.addVehicle(new Vehicle("Ford", "Explorer", 2500));
        garage.addVehicle(new Vehicle("Fiat", "Uno", 500));
        garage.addVehicle(new Vehicle("Fiat", "Cronos", 1000));
        garage.addVehicle(new Vehicle("Fiat", "Torino", 1250));
        garage.addVehicle(new Vehicle("Chevrolet", "Aveo", 1250));
        garage.addVehicle(new Vehicle("Chevrolet", "Spin", 2500));
        garage.addVehicle(new Vehicle("Toyota", "Corola", 1200));
        garage.addVehicle(new Vehicle("Toyota", "Fortuner", 3000));
        garage.addVehicle(new Vehicle("Renault", "Logan", 950));

        /*
        Haciendo uso del método sort en la lista de Vehículos con expresiones lambda, obtén una lista de
        vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado.
        */
        garage.getVehicles().sort(Comparator.comparingDouble(Vehicle::getCost));
        garage.getVehicles().forEach(vehicle -> System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + " " + vehicle.getCost()));
        System.out.println();

        /*
        De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
        */
        garage.getVehicles().sort(Comparator.comparing(Vehicle::getBrand).thenComparing(Vehicle::getCost));
        garage.getVehicles().forEach(vehicle -> System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + " " + vehicle.getCost()));
        System.out.println();

        /*
        Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000 y por último,
         obtén el promedio total de precios de toda la lista de vehículos.
        */

        List<Vehicle> vehiclesUnderOrEqualTo1000 = garage.getVehicles().stream().filter(vehicle -> vehicle.getCost() <= 1000).toList();
        System.out.println("Vehiculos con precio no mayor a 1000");
        vehiclesUnderOrEqualTo1000.forEach(vehicle -> System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + " " + vehicle.getCost()));
        System.out.println();

        List<Vehicle> vehiclesUpperOrEqualTo1000 = garage.getVehicles().stream().filter(vehicle -> vehicle.getCost() >= 1000).toList();
        System.out.println("Vehiculos con precio mayor o igual a 1000");
        vehiclesUpperOrEqualTo1000.forEach(vehicle -> System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + " " + vehicle.getCost()));
        System.out.println();

        double averageCost = garage.getVehicles().stream().mapToDouble(Vehicle::getCost).average().orElse(0.0);

        System.out.println("Promedio total de precios: " + averageCost);
    }
}
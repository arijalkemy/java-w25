package streams_lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje("1", new ArrayList<Vehiculo>());
        garaje.setVehiculos(new Vehiculo("Fiesta", "Ford", 1000));
        garaje.setVehiculos(new Vehiculo("Focus", "Ford", 1200));
        garaje.setVehiculos(new Vehiculo("Explorer", "Ford", 2500));
        garaje.setVehiculos(new Vehiculo("Fiat", "Uno", 500));
        garaje.setVehiculos(new Vehiculo("Fiat", "Cronos", 1000));
        garaje.setVehiculos(new Vehiculo("Fiat", "Torino", 1250));
        garaje.setVehiculos(new Vehiculo("Chevrolet", "Aveo", 1250));
        garaje.setVehiculos(new Vehiculo("Chevrolet", "Spin", 2500));
        garaje.setVehiculos(new Vehiculo("Toyota", "Corola", 1200));
        garaje.setVehiculos(new Vehiculo("Toyota", "Fortuner", 3000));
        garaje.setVehiculos(new Vehiculo("Renault", "Logan", 950));

        // Sorting by costo
//        garaje.getVehiculos().stream().sorted((v1, v2) -> (int) (v1.getCosto() - v2.getCosto())).forEach(System.out::println);

        // Sorting by marca and costo
//        Comparator<Vehiculo> compareByMarcaAndCosto = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
//        garaje.getVehiculos().stream().sorted(compareByMarcaAndCosto).forEach(System.out::println);

        // Vehiculos less than 1000
        ArrayList<Vehiculo> lt = garaje.getVehiculos().stream().filter(v -> v.getCosto() < 1000).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        // Average of vehiculos less than 1000
        double average = lt.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);
        // Vehiculos greater or equal to 1000
        ArrayList<Vehiculo> gte = garaje.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        // Average of vehiculos greater or equal to 1000
        double average2 = gte.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);
        // Average of vehiculo
        System.out.println(Math.round(garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0)));
//        System.out.println(Math.round(garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().ifPresent()));
    }
}

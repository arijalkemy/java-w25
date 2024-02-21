import java.util.Arrays;
import java.util.Comparator;

import models.Garaje;
import models.Vehiculo;

public class App {
    public static void main(String[] args) throws Exception {
        Garaje garaje = new Garaje(1, Arrays.asList(
            new Vehiculo("Ford", "Fiesta", 1000),
            new Vehiculo("Ford", "Focus", 1200),
            new Vehiculo("Ford", "Explorer", 2500),
            new Vehiculo("Fiat", "Uno", 500),
            new Vehiculo("Fiat", "Cronos", 1000),
            new Vehiculo("Fiat", "Torino", 1250),
            new Vehiculo("Chevrolet", "Aveo", 1250),
            new Vehiculo("Chevrolet", "Spin", 2500),
            new Vehiculo("Toyota", "Corola", 1200),
            new Vehiculo("Toyota", "Fortuner", 3000),
            new Vehiculo("Renault", "Logan", 950)));

            System.out.println("Punto3 ------");
            garaje.getVehiculos().stream()
            .sorted(Comparator.comparingInt(Vehiculo::getCosto))
            .forEach(System.out::println);
            System.out.println("Punto4 ------");
            garaje.getVehiculos().stream()
            .sorted(Comparator.comparing(Vehiculo::getMarca)
            .thenComparing(Vehiculo::getCosto))
            .forEach(System.out::println);
            System.out.println("--------------------------");
            garaje.getVehiculos().stream()
            .filter(v -> v.getCosto()<1000)
            .forEach(System.out::println);
            System.out.println("--------------------------");
            garaje.getVehiculos().stream()
            .filter(v -> v.getCosto()>=1000)
            .forEach(System.out::println);
            System.out.println("Punto5 ------");
            System.out.println("Promedio: "+garaje.getVehiculos().stream().mapToInt(v -> v.getCosto()).average().orElseThrow());
    }
}

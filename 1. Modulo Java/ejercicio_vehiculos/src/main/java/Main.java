import model.Garaje;
import model.Vehiculo;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1);

        garaje.getVehiculos().add(new Vehiculo("Ford", "Fiesta", 1000));
        garaje.getVehiculos().add(new Vehiculo("Ford", "Focus", 1200));
        garaje.getVehiculos().add(new Vehiculo("Ford", "Explorer", 1500));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Uno", 500));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Cronos", 1000));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Torino", 1250));
        garaje.getVehiculos().add(new Vehiculo("Chevrolet", "Aveo", 1250));
        garaje.getVehiculos().add(new Vehiculo("Chevrolet", "Spin", 2500));
        garaje.getVehiculos().add(new Vehiculo("Toyota", "Corola", 1200));
        garaje.getVehiculos().add(new Vehiculo("Toyota", "Fortuner", 3000));
        garaje.getVehiculos().add(new Vehiculo("Renault", "Logan", 950));

        System.out.println("----- Autos ordenados por precio de menor a mayor y por marca -----");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .forEach(System.out::println);

        System.out.println("----- Autos con precio menor a $1,000 -----");
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println("----- Autos con precio mayor o igual a $1,000 -----");
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);

        OptionalDouble promedioOptional = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average();
        if (promedioOptional.isPresent()) {
            double promedio = promedioOptional.getAsDouble();
            System.out.println("El promedio total de precios es: " + Math.round(promedio));
        } else {
            System.out.println("No hay vehículos en el garaje.");
        }
    }
}

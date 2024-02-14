package bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main
{
    public static void main( String[] args )
    {
        Garaje garaje = new Garaje(1, new ArrayList<>((Arrays.asList(
                new Vehiculo("Ford", "Fiesta", 1000.0),
                new Vehiculo("Ford", "Focus", 1200.0),
                new Vehiculo("Ford", "Explorer", 2500.0),
                new Vehiculo("Fiat", "Uno", 500.0),
                new Vehiculo("Fiat", "Cronos", 1000.0),
                new Vehiculo("Fiat", "Torino", 1250.0),
                new Vehiculo("Chevrolet", "Aveo", 1250.0),
                new Vehiculo("Chevrolet", "Spin", 2500.0),
                new Vehiculo("Toyota", "Corola", 1200.0),
                new Vehiculo("Toyota", "Fortuner", 3000.0),
                new Vehiculo("Renault", "Logan", 950.0)
                )
        )));

        //p3: precio de menor a mayor
        garaje.getVehiculos().stream().sorted(
                (v1, v2) -> v1.getCosto().compareTo(v2.getCosto())
        ).forEach(System.out::println);

        //p4: Marca y precio
        System.out.println("MARCA Y PRECIO");
        garaje.getVehiculos().stream()
                        .sorted(Comparator.comparing(Vehiculo::getMarca, String.CASE_INSENSITIVE_ORDER)
                    .thenComparing(Vehiculo::getCosto))
            .forEach(System.out::println);
        System.out.println("Fin Marca y precio");
        //p5: promedio
        System.out.println("Promedio total con reduce: " + garaje.getVehiculos().stream().map(Vehiculo::getCosto).reduce(0.0, Double::sum)/garaje.getVehiculos().size());
        System.out.println("Promedio total con mapToDouble: " + garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average());
        System.out.println("Vehiculos con costo menor o igual a 1000: ");
        garaje.getVehiculos().stream().filter(v -> v.getCosto() <=1000).forEach(System.out::println);

        System.out.println("Vehiculos con costo mayor o igual a 1000");
        garaje.getVehiculos().stream().filter(v -> v.getCosto() >=1000).forEach(System.out::println);

        System.out.println(garaje.getVehiculos().stream().collect(Collectors.groupingBy(Vehiculo::getMarca)));

    }

}

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        );

        Garaje garaje = new Garaje(1, vehiculos);

        List<Vehiculo> precioOrdenado = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).toList();

        System.out.println(precioOrdenado);
        System.out.println("----------------------------");

        List<Vehiculo> modeloPrecioOrdenado = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getModelo).thenComparing(Vehiculo::getCosto)).toList();

        System.out.println(modeloPrecioOrdenado);
        System.out.println("----------------------------");

        List<Vehiculo> menor = garaje.getVehiculos().stream().filter(v -> v.getCosto() < 1000).toList();
        List<Vehiculo> mayor = garaje.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).toList();

        System.out.println(menor);
        System.out.println("----------------------------");
        System.out.println(mayor);
        System.out.println("----------------------------");



        Double average = garaje.getVehiculos().stream().mapToInt(Vehiculo::getCosto).average().orElse(0);

        Double averageFord = garaje.getVehiculos().stream().filter(v-> v.getModelo().equals("Ford")).mapToInt(Vehiculo::getCosto).average().orElse(0);

        System.out.println(average);
        System.out.println("----------------------------");
        System.out.println(averageFord);
        System.out.println("----------------------------");
    }
}

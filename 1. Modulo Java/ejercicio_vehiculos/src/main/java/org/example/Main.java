import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garage = new Garaje(7,vehiculos);

        // ..

        for(int i = 0; i < garage.vehiculos.size(); i++) {
            System.out.printf("Vehiculo #%d: %s\n", i, garage.vehiculos.get(i));
        }
        garage.sortGarage();
        System.out.println();
        for(int i = 0; i < garage.vehiculos.size(); i++) {
            System.out.printf("Vehiculo #%d: %s\n", i, garage.vehiculos.get(i));
        }

        // Ejercicio extra.
        vehiculos.stream().filter(x -> x.getModelo().equals("Fiat")).forEach(System.out::println);

    }
}
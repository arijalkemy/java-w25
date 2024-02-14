import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta","Ford",1000));
        vehiculos.add(new Vehiculo("Focus","Ford",1200));
        vehiculos.add(new Vehiculo("Explorer","Ford",2500));
        vehiculos.add(new Vehiculo("Uno","Fiat",500));
        vehiculos.add(new Vehiculo("Cronos","Fiat",1000));
        vehiculos.add(new Vehiculo("Torino","Fiat",1250));
        vehiculos.add(new Vehiculo("Aveo","Chevrolet",1250));
        vehiculos.add(new Vehiculo("Spin","Chevrolet",2500));
        vehiculos.add(new Vehiculo("Corola","Toyota",1200));
        vehiculos.add(new Vehiculo("Fortuner","Toyota",3000));
        vehiculos.add(new Vehiculo("Logan","Renault",950));



        Garaje garaje = new Garaje(1,vehiculos);

        // ejercicio 3
        System.out.println("Vehiculos ordenados por precio de menor a mayor.");
        List<Vehiculo> vehiculosOrdenPrecioMenorAMayor = vehiculos
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());
        vehiculosOrdenPrecioMenorAMayor.stream().forEach(vehiculo -> System.out.println(vehiculo.getCosto()));

        // ejercicio 4
        System.out.println("Vehiculos ordenados por precio y marca de menor a mayor.");
        List<Vehiculo> vehiculosOrdenMarcaYPrecio = vehiculos
                .stream()
                .sorted((Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)))
                .collect(Collectors.toList());
        vehiculosOrdenMarcaYPrecio.stream().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        //ejercicio 5
        System.out.println("Lista de vehiculos con precio inferior a 1000.");
        List<Vehiculo> vehiculosPrecioMenorA1000 = vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto()<1000)
                .toList();
        vehiculosPrecioMenorA1000.stream().forEach(vehiculo -> System.out.println(vehiculo.toString()));
        System.out.println("El promedio del precio de los vehiculos inferiores a 1000 es: " +
                vehiculosPrecioMenorA1000.stream().collect(Collectors.averagingDouble(Vehiculo::getCosto)));

        System.out.println("Lista de vehiculos con precio mayor o igual a 1000.");
        List<Vehiculo> vehiculosPrecioMayorIgualA1000 = vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto()>=1000)
                .toList();
        vehiculosPrecioMayorIgualA1000.stream().forEach(vehiculo -> System.out.println(vehiculo.toString()));
        System.out.println("El promedio del precio de los vehiculos superiores a 1000 es: " +
                vehiculosPrecioMayorIgualA1000.stream().collect(Collectors.averagingDouble(Vehiculo::getCosto)));

        System.out.println("El promedio del precio de todos los vehiculos es: " +
                vehiculos.stream().collect(Collectors.averagingDouble(Vehiculo::getCosto)));
    }
}

package main;
import java.util.Comparator;
import java.util.List;

public class Metodos {

    public void listaVechiculosPorPrecioAsc(List<Vehiculo> listaVehiculos){

        listaVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getPrecio))
                .toList()
                .forEach(System.out::println);

    }

    public void listaVehiculosPorMarcaYPrecioAsc(List<Vehiculo> listaVehiculos){
        listaVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getPrecio))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .toList()
                .forEach(System.out::println);
    }

    public void listaVehiculosMayorMil (List<Vehiculo> listaVehiculos){
        listaVehiculos.stream()
                .filter(auto -> auto.getPrecio() < 1000)
                .toList()
                .forEach(System.out::println);
    }

    public void listaVehiculosMenorMil (List<Vehiculo> listaVehiculos){
        listaVehiculos.stream()
                .filter(auto -> auto.getPrecio() >= 1000)
                .sorted(Comparator.comparing(Vehiculo::getPrecio))
                .toList()
                .forEach(System.out::println);
    }

    public void promedioPrecioVehiculos (List<Vehiculo> listaVehiculos){
        System.out.println("Promedio de precios: " +
                listaVehiculos.stream()
                .mapToInt(Vehiculo::getPrecio)
                .average().orElse(0));
    }

}
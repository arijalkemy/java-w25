package StreamsYGenerics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculoList.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculoList.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculoList.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculoList.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculoList.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculoList.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculoList.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculoList.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculoList.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculoList.add(new Vehiculo("Logan", "Renault", 950));

        Garage garage = new Garage(1, vehiculoList);
        //------
        List<Vehiculo> vehiculosOrdenados = garage.getVehiculoList().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).collect(Collectors.toList());
        System.out.println(vehiculosOrdenados);

        //------
        List<Vehiculo> vehiculosOrdenadosMarcaPrecio = garage
                .getVehiculoList()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println(vehiculosOrdenadosMarcaPrecio);

        //------
        List<Vehiculo> vehiculosMenorMil = garage.getVehiculoList().stream().filter((vehiculo) -> vehiculo.getCosto() < 1000).collect(Collectors.toList());
        System.out.println(vehiculosMenorMil);

        List<Vehiculo> vehiculosMayorIgualMil = garage.getVehiculoList().stream().filter((vehiculo) -> vehiculo.getCosto() >= 1000).collect(Collectors.toList());
        System.out.println(vehiculosMayorIgualMil);

        double vehiculosPromCostos = garage.getVehiculoList().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);
        System.out.println(vehiculosPromCostos);

        //------
        double resultado = garage
                .getVehiculoList()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Vehiculo::getMarca,
                                Collectors.maxBy(Comparator.comparingDouble(Vehiculo::getCosto))
                        )
                )
                .values()
                .stream()
                .mapToDouble(
                        (vehiculoOptional) -> vehiculoOptional.map(Vehiculo::getCosto).orElse(0.0)
                )
                .average()
                .orElse(0.0);

        System.out.println(resultado);
    }
}
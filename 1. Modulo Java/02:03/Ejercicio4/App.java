import java.util.ArrayList;
import java.util.Comparator;

import classes.Garage;
import classes.Vehiculo;

public class App {
        public static void main(String[] args) throws Exception {

                ArrayList<Vehiculo> lista = new ArrayList<>();
                Vehiculo fiesta = new Vehiculo("Fiesta", "Ford", 1000);
                Vehiculo focus = new Vehiculo("Focus", "Ford", 1200);
                Vehiculo explorer = new Vehiculo("Explorer", "Ford", 2500);
                Vehiculo uno = new Vehiculo("Uno", "Fiat", 500);
                Vehiculo cronos = new Vehiculo("Cronos", "Fiat", 1000);
                Vehiculo torino = new Vehiculo("Torino", "Fiat", 1250);
                Vehiculo aveo = new Vehiculo("Aveo", "Chevrolet", 1250);
                Vehiculo spin = new Vehiculo("Spin", "Chevrolet", 2500);
                Vehiculo corola = new Vehiculo("Corola", "Toyota", 1200);
                Vehiculo fortuner = new Vehiculo("Fortuner", "Toyota", 3000);
                Vehiculo logan = new Vehiculo("Logan", "Renault", 950);

                lista.add(fiesta);
                lista.add(focus);
                lista.add(explorer);
                lista.add(uno);
                lista.add(cronos);
                lista.add(torino);
                lista.add(aveo);
                lista.add(spin);
                lista.add(corola);
                lista.add(fortuner);
                lista.add(logan);

                Garage listaAutos = new Garage(1, lista);

                // imprimir vehiculos
                System.out.println("Lista ordenada por costos:");
                listaAutos.getVehiculos().stream()
                                .sorted((x, y) -> Double.compare(x.getCosto(), y.getCosto()))
                                .forEach(auto -> System.out.println(auto.toString()));

                System.out.println("Lista ordenada por nombre y costo:");
                listaAutos.getVehiculos().stream()
                                .sorted(Comparator.comparing(Vehiculo::getMarca)
                                                .thenComparing(Vehiculo::getCosto))
                                .forEach(auto -> System.out.println(auto.toString()));

                System.out.println("Autos precio menor 1000:");
                listaAutos.getVehiculos().stream().filter(p -> p.getCosto() < 1000)
                                .forEach(auto -> System.out.println(auto.toString()));

                System.out.println("Autos precio mayor / igual 1000:");
                listaAutos.getVehiculos().stream().filter(p -> p.getCosto() >= 1000)
                                .forEach(auto -> System.out.println(auto.toString()));

                System.out.println("Promedio total:");
                double promedioPrecios = listaAutos.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average()
                                .orElse(0.0);
                System.out.println(Math.round(promedioPrecios * 100.0) / 100.0);
        }
}

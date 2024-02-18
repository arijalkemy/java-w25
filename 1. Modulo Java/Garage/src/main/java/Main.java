import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> lista = new ArrayList<Vehiculo>();
        lista.add(new Vehiculo("Ford", "Fiesta", 1000, 2010));
        lista.add(new Vehiculo("Ford", "Focus", 1200, 2015));
        lista.add(new Vehiculo("Ford", "Explorer", 2500, 2000));
        lista.add(new Vehiculo("Fiat", "Uno", 500, 1997));
        lista.add(new Vehiculo("Fiat", "Cronos", 1000, 2018));
        lista.add(new Vehiculo("Fiat", "Torino", 1250, 1965));
        lista.add(new Vehiculo("Chevrolet", "Aveo", 1250, 2020));
        lista.add(new Vehiculo("Chevrolet", "Spin", 2500, 2021));
        lista.add(new Vehiculo("Toyota", "Corola", 1200, 2022));
        lista.add(new Vehiculo("Toyota", "Fortuner", 3000, 2018));
        lista.add(new Vehiculo("Renault", "Logan", 950, 2009));

        Garage garage = new Garage(1, lista);

        System.out.println("\n----------------------------");
        System.out.println("Vehiculos ordenados por precio:");
        System.out.println(garage.ordernarVehiculosPrecio());

        System.out.println("\n----------------------------");
        System.out.println("Vehiculos ordenados por marca y precio:");
        System.out.println(garage.ordernarVehiculosMarcaPrecio());

        System.out.println("\n----------------------------");
        System.out.println("Vehiculos menores a 1000:");
        System.out.println(garage.ordernarVehiculosMenor1000());

        System.out.println("\n----------------------------");
        System.out.println("Vehiculos mayores o iguales a 1000 por precio:");
        System.out.println(garage.ordernarVehiculosMayorIgual1000());

        System.out.println("\n----------------------------");
        System.out.println("Promedio del costo de los vehiculos:");
        System.out.printf("%.2f\n", garage.promedioTotal());

        System.out.println("\n----------------------------");
        System.out.println("Precios con descuento para años anteriores o iguales a 2000:");
        System.out.println(garage.aplicarDescuento(2000, 20));
    }
}
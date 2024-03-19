package main;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Garaje garajeInicial = new Garaje("Garaje inicial", Arrays.asList(
                new Vehiculo("Ford","Fiesta",1000),
                new Vehiculo("Ford","Focus",1200),
                new Vehiculo("Ford","Explorer",2500),
                new Vehiculo("Fiat","Uno",500),
                new Vehiculo("Fiat","Cronos",1000),
                new Vehiculo("Fiat","Torino",1250),
                new Vehiculo("Chevrolet","Aveo",1250),
                new Vehiculo("Chevrolet","Spin",2500),
                new Vehiculo("Toyota","Corolla",1200),
                new Vehiculo("Toyota","Fortuner",3000),
                new Vehiculo("Renault","Logan",950)));

        Metodos metodos = new Metodos();
        metodos.listaVechiculosPorPrecioAsc(garajeInicial.getVehiculoList());
        metodos.listaVehiculosPorMarcaYPrecioAsc(garajeInicial.getVehiculoList());
        metodos.listaVehiculosMayorMil(garajeInicial.getVehiculoList());
        metodos.listaVehiculosMenorMil(garajeInicial.getVehiculoList());
        metodos.promedioPrecioVehiculos(garajeInicial.getVehiculoList());

    }
}
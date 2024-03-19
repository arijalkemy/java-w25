package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Consultas {

    List<Localizador> localizadorList = new ArrayList<>();

    public Consultas(List<Localizador> localizadorList) {
        this.localizadorList = localizadorList;
    }

    public void cantidadLocalizadoresVendidos(){
        System.out.println("\nLa cantidad de localizadores vendidos es: " + localizadorList.size());
    }

    public void cantidadTotalReservas(){
        int cantidadReservas = 0;
        for (int i = 0; i < localizadorList.size(); i++){
            cantidadReservas = cantidadReservas + localizadorList.get(i).getPaquete().stream().mapToInt(Reserva::getCantidadReservas).sum();
        }
        System.out.println("\nEl total de reservas es :" + cantidadReservas);
    }

    public void diccionarioReservas(){
        Map<String, Reserva> mapReservas = new HashMap<>();
        int count = 200;
        for(int i = 0; i < localizadorList.size(); i++){
            List<Reserva> reserva = localizadorList.get(i).getPaquete();
;            for (int j = 0; j < reserva.size(); j++){
                mapReservas.put(String.valueOf(count), reserva.get(j));
                count++;
            }
        }
        System.out.println("\n----------DICCIONARIO DE RESERVAS---------");
        for(Map.Entry<String,Reserva> entry : mapReservas.entrySet()){
            String id = entry.getKey();
            Reserva reserva = entry.getValue();
            System.out.println("ID de reserva: " + id);
            System.out.println("Reserva: " + reserva);
            System.out.println();
        }
        System.out.println("----------------------------------");
    }

    public void totalVendido(){
        double total = localizadorList.stream().mapToDouble(Localizador::getTotal).sum();
        System.out.println("\nEl total de ventas es: $" + total);
    }

    public void promedioVentasLocalizadores(){
        double prom = localizadorList.stream().mapToDouble(Localizador::getTotal).average().getAsDouble();
        System.out.println("\nEl promedio de ventas es: $" + prom);
    }
}

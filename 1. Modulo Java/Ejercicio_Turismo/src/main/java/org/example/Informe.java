package org.example;

import java.util.HashMap;
import java.util.List;

public class Informe {
    private List<Localizador> totalLocalizadores = RepositorioLocalizador.getListaDeLocalizadores();
    //long totalReservas = totalLocalizadores.forEach(localizador -> localizador.getListaDeReservas().stream().count());

    private double totalReservas = totalLocalizadores.stream().mapToDouble(localizador -> localizador.getListaDeReservas().stream().count()).sum();
    private double ventasTotales = totalLocalizadores
            .stream().mapToDouble(localizador -> localizador.getMontoFinal()).sum();

    public double getLocalizadoresVendidos(){
        return totalLocalizadores.stream().count();
    }

    public double getReservasTotales(){
        return totalReservas;
    }

    public double getVentasTotales(){
        return ventasTotales;
    }

    public double getPromedioVentas(){
        return ventasTotales / totalLocalizadores.stream().count();
    }

    public HashMap<Reserva, Integer> getTodasLasReservas() {
        HashMap<Reserva, Integer> reservas = new HashMap<>();
        totalLocalizadores.forEach(localizador -> localizador.getListaDeReservas()
                .forEach(reserva -> reservas.put(reserva, reservas.getOrDefault(reserva, 0) + 1)));

        return reservas;
    }
}

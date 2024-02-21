package main.java.com.bootcamp.repository;

import main.java.com.bootcamp.Main;
import main.java.com.bootcamp.model.Localizador;
import main.java.com.bootcamp.model.Reserva;
import main.java.com.bootcamp.model.TipoReserva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryLocalizador {
    private List<Localizador> localizadores;

    public RepositoryLocalizador() {
        localizadores = new ArrayList<>();
    }
    public void add(Localizador localizador){
        if (localizadores.stream().filter(localizador1 -> localizador1.getCliente() == localizador.getCliente()).count() >= 2){
            localizador.setClienteFrecuente(true);
        }
        localizadores.add(localizador);
    }
    public void mostrarLocalizadores(){
        localizadores.forEach(System.out::println);
    }
    public long contarLocalizadores(){
        return this.localizadores.size();
    }
    public long contarReservas(){
        return localizadores.stream().mapToLong(Localizador::contarReservas).sum();
    }

    public Map<TipoReserva, List<Reserva>> reservasAgrupadas(){
        Map<TipoReserva, List<Reserva>> reservas = new HashMap<>();
        for(Localizador l: localizadores){
            for (Reserva r: l.getReservas()){
                ArrayList<Reserva> res = new ArrayList<>();
                res.add(r);
                if (reservas.containsKey(r.getTipoReserva())) {
                    reservas.get(r.getTipoReserva()).add(r);
                } else {
                    reservas.put(r.getTipoReserva(), res);
                }
            }
        }
        return reservas;
    }

    public void mostrarPorTipoReserva(){
        Map<TipoReserva, List<Reserva>>reservas = reservasAgrupadas();
        System.out.println(reservas);

    }

    public double mostrarTotalVentas(){
        return this.localizadores.stream().mapToDouble(Localizador::getTotal).sum();
    }

    public double mostrarTotalPromedio(){
        return this.mostrarTotalVentas() / this.contarLocalizadores();
    }


}

package bootcamp.Repositorios;

import bootcamp.Models.Localizador;
import bootcamp.Models.Reserva;
import bootcamp.Models.TipoReservasEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RespositorioLocalizador {
    private List<Localizador> localizadores;

    public RespositorioLocalizador() {
        localizadores = new ArrayList<>();
    }
    public void add(Localizador localizador){
        if(localizadores.stream().filter(local -> local.getCliente() == localizador.getCliente()).count() >= 2){
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

    public Map<TipoReservasEnum, List<Reserva>> reservasAgrupadas(){
        Map<TipoReservasEnum, List<Reserva>> reservas = new HashMap<>();
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
        Map<TipoReservasEnum, List<Reserva>>reservas = reservasAgrupadas();
        System.out.println(reservas);

    }

    public double mostrarTotalVentas(){
        return this.localizadores.stream().mapToDouble(Localizador::getTotal).sum();
    }

    public double mostrarTotalPromedio(){
        return this.mostrarTotalVentas() / this.contarLocalizadores();
    }

}

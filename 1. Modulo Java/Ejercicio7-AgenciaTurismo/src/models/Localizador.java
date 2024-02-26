package models;

import repository.Repositorio;

import java.util.*;
import java.util.stream.Collectors;

public class Localizador {
    private int id;

    private Client client;

    private  List<Reserva> reservas = new ArrayList<>();

    private int total;

    private boolean esCompleto;

    private Map<TipoReserva, Boolean> map;

    public Localizador(int id, Client client, List<Reserva> reservas) {
        this.id = id;
        this.client = client;
        this.setReservas(reservas);
        this.setEsCompleto();

        this.map = new HashMap<>();
        map.put(TipoReserva.ALIMENTACION, false);
        map.put(TipoReserva.TIQUETES, false);
        map.put(TipoReserva.TRANSPORTE, false);
        map.put(TipoReserva.HOTEL, false);
    }

    private void setEsCompleto(){
        if (this.reservas.size() < 4){
            this.esCompleto = false;
        }



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;

        if(reservas.size() > 4){
            throw new RuntimeException("No se permite mas de 4 reservas por localizador");
        }

        //Alternativa para determinar si paquete es completo
        List<TipoReserva> tipoReservasActuales = this.reservas.stream().map( r -> r.getTipo()).collect(Collectors.toList());
        this.esCompleto = tipoReservasActuales.containsAll(Arrays.asList(TipoReserva.values()));

        //Alternativa usando mapas incompleta
//        reservas.stream().forEach( reserva -> {
//            TipoReserva tipo  = reserva.getTipo();
//            boolean isPresent = map.get(tipo);
//
//           // isPresent ? throw new RuntimeException("Reserva existente") :
//
//        });

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private double calcularTotal(){
        double total = this.reservas.stream().mapToDouble(Reserva::getPrice).sum();

        if(Repositorio.getClientByDni(this.client.getDni()) >= 2){
            total *= 0.95;
        }

        return total;
    }
}

package agencia.repository;

import agencia.reserva.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservaRepository implements Repository<Reserva>{

    static List<Reserva> reservas = new ArrayList<>();

    @Override
    public List<Reserva> getAll() {
        return reservas;
    }

    @Override
    public Optional<Reserva> getOne(int id) {
        return reservas.stream()
                .filter(reserva -> reserva.getIdReserva() == id)
                .findFirst();
    }

    @Override
    public Reserva insert(Reserva elementInsert) {
        Optional<Reserva> existe = this.getOne(elementInsert.getIdReserva());

        if (existe.isEmpty()){
            reservas.add(elementInsert);

            return elementInsert;
        }

        return null;
    }

    @Override
    public Reserva update(Reserva elementUpdate) {
        return null;
    }

    @Override
    public Reserva delete(int id) {
        return null;
    }






}

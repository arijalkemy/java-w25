package agencia.repository;

import agencia.localizador.Localizador;
import agencia.reserva.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocalizadorRepository implements Repository<Localizador>{

    static  List<Localizador> localizadores = new ArrayList<>();


    @Override
    public List<Localizador> getAll() {
        return localizadores;
    }

    @Override
    public Optional<Localizador> getOne(int id) {
        return localizadores.stream()
                .filter(localizador -> localizador.getId() == id)
                .findFirst();
    }

    @Override
    public Localizador insert(Localizador elementInsert) {
        Optional<Localizador> existe = this.getOne(elementInsert.getId());

        if (existe.isEmpty()){
            localizadores.add(elementInsert);

            return elementInsert;
        }

        return null;
    }


    public long encontrarLocalizadorByClienteId(int clienteId){
        return  localizadores.stream()
                .filter(localizador -> localizador.getCliente().getIdCliente() == clienteId)
                .count();
    }

    @Override
    public Localizador update(Localizador elementUpdate) {
        return null;
    }

    @Override
    public Localizador delete(int id) {
        return null;
    }
}

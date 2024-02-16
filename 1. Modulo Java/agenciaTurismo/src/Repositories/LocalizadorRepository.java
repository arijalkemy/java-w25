package Repositories;

import Interfaces.ICRUD;
import Models.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository implements ICRUD<Localizador> {

    public static List<Localizador> localizadorList = new ArrayList<>();

    @Override
    public void create(Localizador localizador) {
        if (localizadorList.stream().noneMatch(l -> l.getId() == (localizador.getId()))) {
            int id = !localizadorList.isEmpty() ? localizadorList.get(localizadorList.size() -1).getId() + 1 : 1;
            localizador.setId(id);
            localizadorList.add(localizador);
        }
    }

    @Override
    public List<Localizador> read() {
        return localizadorList;
    }

    @Override
    public void update(Localizador localizador) {
        Localizador localizadorEncontrado = findById(localizador.getId());
        if (localizadorEncontrado != null) {
            localizadorList.remove(localizadorEncontrado);
            localizadorList.add(localizador);
        } else {
            System.out.println("Localizador no existe");
        }
    }


    @Override
    public Localizador findById(int localizadorId) {
        return localizadorList.stream().filter(l -> l.getId() == localizadorId).findFirst().orElse(null);



    }

    @Override
    public void delete(Localizador localizador) {
        Localizador localizadorEncontrado = findById(localizador.getId());
        if (localizadorEncontrado != null) {
            localizadorList.remove(localizadorEncontrado);
        } else {
            System.out.println("Localizador no existe");
        }

    }
}

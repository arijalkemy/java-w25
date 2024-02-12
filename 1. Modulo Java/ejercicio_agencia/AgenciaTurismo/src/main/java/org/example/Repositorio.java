package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repositorio {

    ArrayList<Localizador> localizadores = new ArrayList<Localizador>();

    public Repositorio(ArrayList<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public void borrarLocalizador(Localizador localizador) {
        if (localizador != null) {
            localizadores.remove(localizador);
        }
    }

    public ArrayList<Localizador> getLocalizadoresByDni(int dni){
        return  localizadores.stream().filter(localizador -> localizador.getCliente().getDni() == dni).collect(Collectors.toCollection(ArrayList::new));
    }
}

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioLocalizador {

    private static List<Localizador> listaDeLocalizadores = new ArrayList<>();

    public static void addLocalizador(Localizador l){
        listaDeLocalizadores.add(l);
    }

    public static List<Localizador> getListaDeLocalizadores() {
        return listaDeLocalizadores;
    }

    public static long countByClient(Cliente c) {
        return RepositorioLocalizador.getListaDeLocalizadores().stream()
                .filter(localizador -> localizador.getCliente() == c).count();
    }
}

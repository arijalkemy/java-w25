package org.example;

import java.util.List;

public class RepositorioLocalizador {

    List<Localizador> listaDeLocalizadores;

    public void addLocalizador(Localizador l){
        this.listaDeLocalizadores.add(l);
    }

    public List<Localizador> getListaDeLocalizadores() {
        return listaDeLocalizadores;
    }
}

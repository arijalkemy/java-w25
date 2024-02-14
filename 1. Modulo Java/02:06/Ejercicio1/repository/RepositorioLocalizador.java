package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.classes.*;;

public class RepositorioLocalizador {
    private List<Localizador> listaLocalizadoresGenerados;

    public RepositorioLocalizador() {
        this.listaLocalizadoresGenerados = new ArrayList<>();
    }

    public List<Localizador> getlistaLocalizadoresGenerados() {
        return this.listaLocalizadoresGenerados;
    }

    public void setlistaLocalizadoresGenerados(List<Localizador> listaLocalizadoresGenerados) {
        this.listaLocalizadoresGenerados = listaLocalizadoresGenerados;
    }

}

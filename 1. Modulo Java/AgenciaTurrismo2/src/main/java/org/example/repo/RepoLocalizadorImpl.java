package org.example.repo;


import org.example.Localizador;

import java.util.ArrayList;
import java.util.List;

public class RepoLocalizadorImpl implements IRepositorio<Localizador> {
    private List<Localizador> localizadorList;

    public RepoLocalizadorImpl() {
        this.localizadorList = new ArrayList<>();
    }

    @Override
    public List<Localizador> getList() {
        return localizadorList;
    }

    @Override
    public void add(Localizador t) {

        localizadorList.add(t);
    }
}

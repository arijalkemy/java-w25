package org.example.repositorios;

import org.example.clases.Localizador;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RepositorioLocalizador implements IRepository<Localizador> {
    private ArrayList<Localizador> localizadores;
    @Override
    public void save(Localizador obj){
        localizadores.add(obj);

    }
}

package repositorios;

import Clases.Localizador;

import java.util.ArrayList;

public class RepoLocalizador implements IRepository<Localizador> {
    private ArrayList<Localizador> localizadores;
    @Override
    public void save(Localizador obj) {
        localizadores.add(obj);
    }

}

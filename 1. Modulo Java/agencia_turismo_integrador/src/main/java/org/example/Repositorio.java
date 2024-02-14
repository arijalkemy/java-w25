package org.example;

import java.util.*;

public class Repositorio {
    private Map<Cliente, List<Localizador>> repo;

    public Repositorio() {
        this.repo = new HashMap<>();
    }

    public Repositorio(Map<Cliente, List<Localizador>> repo) {
        this.repo = repo;
    }

    public Map<Cliente, List<Localizador>> getRepositorio() {
        return repo;
    }

    public void setRepositorio(Map<Cliente, List<Localizador>> repo) {
        this.repo = Repositorio.this.repo;
    }

    public void addLocalizador(Cliente cliente, Localizador localizador) {
        if (repo.containsKey(cliente)) {
            repo.get(cliente).add(localizador);
        } else {
            repo.put(cliente, new ArrayList<>());
            repo.get(cliente).add(localizador);
        }
    }

    public List<Localizador> getLocalizadoresByCliente(Cliente cliente) {
        if (repo.containsKey(cliente)) return repo.get(cliente).stream().toList();

        return null;
    }

    @Override
    public String toString() {
        return "Repositorio{" + "repositorio =" + repo.toString() + '}';
    }
}

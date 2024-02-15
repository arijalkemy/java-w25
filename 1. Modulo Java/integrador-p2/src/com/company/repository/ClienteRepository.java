package com.company.repository;

import com.company.model.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ClienteRepository<T> implements Repository<T>{
    private List<T> clientes = new ArrayList<>();


    public ClienteRepository() {
        this.clientes = (List<T>) new ArrayList<Cliente>(Arrays.asList(
                new Cliente("123","Cristiano","Ronaldo"),
                new Cliente("456","Lionel","Messi"),
                new Cliente("789","Erling","Haaland")
        ));
    }

    public ClienteRepository(List<T> clientes) {
        this.clientes = clientes;
    }

    @Override
    public boolean add(T t) {
        return clientes.add(t);
    }

    @Override
    public List<T> findAll() {
        return clientes;
    }

    @Override
    public Optional<T> findById(String id) {
        Optional<T> elem = Optional.empty();
        for (T t: clientes) {
            if(((Cliente) t).getDni().equals(id)){
                elem =  Optional.of(t);
            }
        }
        return elem;
    }
}

package org.example.repo;
import org.example.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RepoClienteImpl implements IRepositorio<Cliente>{

    private List<Cliente> clienteList;

    public RepoClienteImpl() {
        this.clienteList = new ArrayList<>();
    }

    @Override
    public List<Cliente> getList() {
        return clienteList;
    }

    @Override
    public void add(Cliente t) {
        clienteList.add(t);
    }
}

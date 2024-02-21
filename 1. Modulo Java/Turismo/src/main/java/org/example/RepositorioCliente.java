package org.example;
import java.util.List;
public class RepositorioCliente {
    List<Cliente> listaDeClientes;

    public void addCliente(Cliente c){
        this.listaDeClientes.add(c);
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }
}

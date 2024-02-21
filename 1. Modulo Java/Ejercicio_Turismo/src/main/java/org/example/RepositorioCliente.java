package org.example;
import java.util.List;
public class RepositorioCliente {
    private static List<Cliente> listaDeClientes;

    public static void addCliente(Cliente c){
        listaDeClientes.add(c);
    }

    public static List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }
}

package org.example.repositorios;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;


@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class RepositorioCliente {
    List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

}

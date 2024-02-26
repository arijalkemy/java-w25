package repository;

import models.Client;
import models.Localizador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repositorio {

    private static List<Localizador> localizadores = new ArrayList<>();
    private static List<Client> clientes = new ArrayList<>();

    public static List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public static void setLocalizadores(List<Localizador> localizadores) {
        Repositorio.localizadores = localizadores;
    }

    public static List<Client> getClientes() {
        return clientes;
    }

    public static void setClientes(List<Client> clientes) {
        Repositorio.clientes = clientes;
    }

    public static Long getClientByDni(String dni){
        return localizadores.stream().filter(c -> c.getClient().getDni().equals(dni)).count();
    }
}

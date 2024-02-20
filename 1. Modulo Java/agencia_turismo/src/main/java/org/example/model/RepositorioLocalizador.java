package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {

    public static List<Localizador> localizadorList = new ArrayList<>();

    public static void guardarLocalizador(Localizador localizador){
        localizadorList.add(localizador);
    }

    public static boolean adquirioAlMenosDosLocalizadores(Cliente cliente){

        int cantidad = (int) localizadorList.stream()
                            .filter(x -> x.getCliente().getIdCliente() == cliente.getIdCliente())
                            .count();
        return cantidad >= 2;
    }
}

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("Selva y arroyos",1));
        categorias.add(new Categoria("Selva, arroyos y barro",2));
        categorias.add(new Categoria("Selva, arroyos, barro y escalar",3));


    }
}
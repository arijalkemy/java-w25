package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Documento libro = new LibroPDF(200, "Joseph King", "A man in the praire", "Adventure");
        Informe informe = new Informe("Este informe fue hecho para la universidad de ...", "Esteban Quito", "Josefina Aguilera", 15);

        List<String> skills = new ArrayList<>();
        skills.add("A skill");
        skills.add("Another skill");
        Curriculum cv = new Curriculum("Matias", "Gómez", "23.123.233", skills);

        System.out.println("=============== LIBRO ================");
        Imprimible.imprimir(libro);
        System.out.println("============== INFORME ===============");
        Imprimible.imprimir(informe);
        System.out.println("================= CV =================");
        Imprimible.imprimir(cv);
    }
}

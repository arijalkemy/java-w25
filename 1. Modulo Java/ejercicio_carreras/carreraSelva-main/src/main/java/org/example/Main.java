package org.example;

import java.util.Scanner;

import org.example.entidades.Circuito;
import org.example.entidades.Inscripcion;
import org.example.entidades.Participante;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Circuito chico = new Circuito(1, "Circuito Chico", "2 km por selva y arroyos", 1300, 1500);
        Circuito medio = new Circuito(2, "Circuito Mediano", "5 km por selva, arroyos y barro", 1300, 1500);
        Circuito avanzado = new Circuito(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 1300, 1500);

        // crear objet participante
        List<Participante> participantes = new ArrayList<>();
        participantes.add(new Participante(1, "42000909", "Nico", "Molina", 18, "351452461", "4575157457147", "A+"));
        participantes.add(new Participante(2, "42000909", "Nico", "Molina", 17, "351452461", "4575157457147", "A+"));
        participantes.add(new Participante(3, "42000909", "Nico", "Molina", 23, "351452461", "4575157457147", "A+"));
        participantes.add(new Participante(4, "42000909", "Nico", "Molina", 15, "351452461", "4575157457147", "A+"));
        participantes.add(new Participante(5, "42000909", "Nico", "Molina", 30, "351452461", "4575157457147", "A+"));

        // crear inscripciones
        List<Inscripcion> inscripciones = new ArrayList<>();
        inscripciones.add(new Inscripcion(1, participantes.get(1), chico));
        inscripciones.add(new Inscripcion(2, participantes.get(2), medio));
        inscripciones.add(new Inscripcion(3, participantes.get(3), avanzado));
        inscripciones.add(new Inscripcion(4, participantes.get(4), medio));
        inscripciones.add(new Inscripcion(4, participantes.get(5), avanzado));


        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar Categoria");
        System.out.println("1-chico");
        System.out.println("2-medio");
        System.out.println("3-avanzado");
        System.out.println();
        int cate = scan.nextInt();


    }
}
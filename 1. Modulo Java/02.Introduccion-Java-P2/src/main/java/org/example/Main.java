package org.example;

import java.util.Scanner;

import org.example.entidades.Circuito;
import org.example.entidades.Competencia;
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
        participantes.add(new Participante(1, "42000909", "Nifco", "Molitrtna", 18, "351452461", "4575157457147", "A+"));
        participantes.add(new Participante(2, "4206767909", "Nicgfo", "Moretrlina", 17, "351452461", "4575157457147", "A+"));
        participantes.add(new Participante(3, "42760909", "Nicgo", "Molierena", 23, "351452461", "4575157457147", "A+"));
        participantes.add(new Participante(4, "4250909", "Nicffgo", "Molirena", 15, "351452461", "4575157457147", "A+"));
        participantes.add(new Participante(5, "45600909", "Nico", "Molina", 30, "351452461", "4575157457147", "A+"));

        // crear inscripciones
        List<Inscripcion> inscripciones = new ArrayList<>();
        inscripciones.add(new Inscripcion(1, participantes.get(1), chico));
        inscripciones.add(new Inscripcion(2, participantes.get(2), medio));
        inscripciones.add(new Inscripcion(3, participantes.get(3), avanzado));
        inscripciones.add(new Inscripcion(4, participantes.get(4), medio));
        inscripciones.add(new Inscripcion(4, participantes.get(5), avanzado));

        // crear la competencia
        Competencia competencia = new Competencia(inscripciones);

        Scanner scan = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Ingrese el número de la opción deseada");
            System.out.println("1-Mostrar inscriptos a una categoría \n 2-Desinscribir a un participante");
            System.out.println("3-Calcular el monto recaudado por una categoría \n 0-Salir");
            opcion = scan.nextInt();
            System.out.println("Ingrese el número según el circuito");
            System.out.println("0- Circuito chico \n 1- Circuito medio \n 2- Circuito grande");
            int idCircuito = scan.nextInt(1);

            switch (opcion) {
                case 1 -> competencia.mostrarPorCategoria(idCircuito);
                case 2 -> {
                    System.out.println("Ingrese el id del participante a eliminar");
                    competencia.eliminarParticipante(scan.nextInt(), idCircuito);
                }
                case 3 -> competencia.calcularTotalPorCategoria(idCircuito);
                default -> System.out.println("Cerrando la sesión. Adiosirigillo");
            }
        } while (opcion != 0);



    }
}
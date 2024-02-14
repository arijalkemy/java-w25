package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


       Carrera carrera = new Carrera(new ArrayList<Participante>());

        CircuitoChico circuitoChico = new CircuitoChico(1, "Circuito Chico", "Circuito de 2km");
        CircuitoMedio circuitoMedio = new CircuitoMedio(2, "Circuito Medio", "Circuito de 5km");
        CircuitoAvanzado circuitoAvanzado = new CircuitoAvanzado(3, "Circuito Avanzado", "Circuito de 10km");

        Participante participante = new Participante(1, "37830728", "Juan", "Perez", 28,"3404564621","101","A+");
        Participante participante2 = new Participante(2, "37830728", "Pedro", "Lopez", 18,"3404564621","101","A+");
        Participante participante3 = new Participante(3, "37830728", "Maria", "Gomez", 25,"3404564621","101","A+");
        Participante participante4 = new Participante(4, "37830728", "Juan", "Perez", 28,"3404564621","101","A+");


        Inscripcion inscripcion = new Inscripcion(1, circuitoAvanzado, participante);
        Inscripcion inscripcion2 = new Inscripcion(2, circuitoMedio, participante2);
        Inscripcion inscripcion3 = new Inscripcion(3, circuitoChico, participante3);
        Inscripcion inscripcion4 = new Inscripcion(4, circuitoChico, participante4);



        System.out.println("Monto inscripcion: $"+inscripcion.getMontoInscripcion());

        carrera.inscribirParticipante(inscripcion);
        carrera.inscribirParticipante(inscripcion2);
        carrera.inscribirParticipante(inscripcion3);
        carrera.inscribirParticipante(inscripcion4);

        System.out.println("Participantes inscriptos: "+carrera.getParticipantes().size());

        for (Participante p : carrera.getParticipantes()) {
                System.out.println(p.getNombre());
        }
        carrera.desinscribirParticipante(participante);
        System.out.println("Participantes inscriptos: "+carrera.getParticipantes().size());

        for (Participante p : carrera.getParticipantes()) {
                System.out.println(p.getNombre());
        }


        System.out.println("Total recaudado: $"+carrera.getTotalRecaudado());
        System.out.println("Total recaudado Circuito Chico: $"+carrera.getTotalChico());
        System.out.println("Total recaudado Circuito Medio: $"+carrera.getTotalMedio());
        System.out.println("Total recaudado Circuito Avanzado: $"+carrera.getTotalAvanzado());

    }
}
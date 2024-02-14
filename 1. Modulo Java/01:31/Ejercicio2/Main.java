package com.example;

import com.example.classes.Categoria;
import com.example.classes.Inscripcion;
import com.example.classes.Participante;

public class Main {
    public static void main(String[] args) {

        // a:
        Categoria circuitoChico = new Categoria("Circuito Chico", "Selva y arroyos", 2, 1500, 1300);
        Categoria circuitoMedio = new Categoria("Circuito Medio", "Selva, arroyos & barro", 5, 2300, 2000);
        Categoria circuitoAvanzado = new Categoria("Circuito Avanzado", "Selva, arroyos, barro & escalada de piedra",
                10, 2800, 0);

        // b:
        Participante participante1 = new Participante("nombre1", "apellido1", 21, 1122223333, 1122223333, "A+");
        Inscripcion inscripcionParticipante1 = new Inscripcion(circuitoChico, participante1);
        System.out.println(inscripcionParticipante1.montoTotalAbonar());

        // c:
        Participante participante2 = new Participante("nombre2", "apellido2", 15, 1122223333, 1122223333, "A+");
        Inscripcion inscripcionParticipante2 = new Inscripcion(circuitoMedio, participante2);
        Participante participante3 = new Participante("nombre3", "apellido3", 19, 1122223333, 1122223333, "A+");
        Inscripcion inscripcionParticipante3 = new Inscripcion(circuitoAvanzado, participante3);

        // d:
        circuitoAvanzado.mostrarParticipantes();

        // e:
        inscripcionParticipante3.desinscribir();
        circuitoAvanzado.mostrarParticipantes();

        // f:
        System.out.println(circuitoAvanzado.getTotalGanancias());

    }
}
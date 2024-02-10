package org.example;

import java.util.HashMap;

public class Inscripcion {
    public static HashMap<Participante,Inscripcion> inscritos = new HashMap<>();
    private final int numInscripcion;
    private final Categoria categoria;
    private final Participante participante;
    private final int abono;

    Inscripcion (int numInscripcion, Categoria categoria, Participante participante, int abono) {
        this.numInscripcion = numInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.abono = abono;
    }

    public static void inscribir (Participante participante, Inscripcion inscripcion) {
        inscritos.put(participante, inscripcion);
    }

    public static void desinscribir (Participante participante) {
        inscritos.remove(participante);
    }

    public static void mostrarInscritos (Categoria categoria) {
        for (Inscripcion inscripcion : inscritos.values()) {
            if (inscripcion.categoria == categoria) {
                System.out.println(
                    "Número de inscripción: " + inscripcion.numInscripcion + "\n" +
                    "Participante # " + inscripcion.participante.getNumParticipante() + ":\n" +
                    "\tDNI: " + inscripcion.participante.getDni() + "\n" +
                    "\tNombre: " + inscripcion.participante.getNombre() + "\n" +
                    "\tApellido: " + inscripcion.participante.getApellido() + "\n" +
                    "\tEdad: " + inscripcion.participante.getEdad() + "\n" +
                    "\tCelular: " + inscripcion.participante.getCelular() + "\n" +
                    "\tNúmero de emergencia: " + inscripcion.participante.getNumEmergencia() + "\n" +
                    "\tRH: " + inscripcion.participante.getRh() + "\n" +
                    "Abono: $" + inscripcion.abono + "\n"
                );
            }
        }
    }

    public static void calcularMontos () {
        long[] montos = new long[4];
        for (Inscripcion inscripcion : inscritos.values()) {
            switch (inscripcion.categoria) {
                case CIRCUITO_CHICO -> {
                    montos[0] += inscripcion.abono;
                    montos[3] += inscripcion.abono;
                }
                case CIRCUITO_MEDIO -> {
                    montos[1] += inscripcion.abono;
                    montos[3] += inscripcion.abono;
                }
                case CIRCUITO_AVANZADO -> {
                    montos[2] += inscripcion.abono;
                    montos[3] += inscripcion.abono;
                }
            }
        }
        System.out.println("Monto total recaudado del circuito chico: $" + montos[0]);
        System.out.println("Monto total recaudado del circuito medio: $" + montos[1]);
        System.out.println("Monto total recaudado del circuito avanzado: $" + montos[2]);
        System.out.println("Monto total recaudado de la carrera para todas las categorías: $" + montos[3]);
    }
}

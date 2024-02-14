package org.clase31_01_24.P2;

import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Circuito circuitoChico = new Circuito("Circuito chico", 2,1500,1300);
        Circuito circuitoMedio = new Circuito("Circuito medio", 5,2300,2000);
        Circuito circuitoAvanzado = new Circuito("Circuito avanzado", 10,2800,0);

        Participante participante1 = new Participante(1,"234234234","Facundo","Salvia",33,123123123,123213123,"A+");

    }

    public static class Circuito {
        String nombre;
        Integer distancia;
        Integer precioAdultos;
        Integer precioMenores;

        public Circuito(String nombre, Integer distancia, Integer precioAdultos, Integer precioMenores) {
            this.nombre = nombre;
            this.distancia = distancia;
            this.precioAdultos = precioAdultos;
            this.precioMenores = precioMenores;
        }
    }

    public class Inscripciones {
        HashSet<Participante> participanteList;
    }

    public class Inscripcion {
        Participante participante;
        String categoria;

        public Inscripcion(Participante participante, String categoria) {
            this.participante = participante;
            this.categoria = categoria;
        }
    }

    public static class Participante {
        Integer numeroDeParticipante;
        String dni;
        String nombre;
        String apellido; Integer edad;
        long celular;
        long númeroDeEmergencia;
        String grupoSanguíneo;

        public Participante(Integer numeroDeParticipante, String dni, String nombre, String apellido, Integer edad, long celular, long númeroDeEmergencia, String grupoSanguíneo) {
            this.numeroDeParticipante = numeroDeParticipante;
            this.dni = dni;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.celular = celular;
            this.númeroDeEmergencia = númeroDeEmergencia;
            this.grupoSanguíneo = grupoSanguíneo;
        }
    }
}

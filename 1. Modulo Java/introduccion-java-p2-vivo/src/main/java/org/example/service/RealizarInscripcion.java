package org.example.service;

import org.example.models.Circuito;
import org.example.models.Inscripcion;
import org.example.models.Participante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RealizarInscripcion {

    public static Map<Integer, Inscripcion> inscripcionesFormalizadas = new HashMap<>();

    public enum Categorias{
            chico, medio, avanzado
    }
    public static void Inscribir(int numero, Circuito circuito, Participante participante){
        double monto = 0.0;
        boolean[] participanteExiste = new boolean[1];

        inscripcionesFormalizadas.forEach((integer, inscripcion) -> {
            if(inscripcion.getParticipante().getDni() == participante.getDni()){
                participanteExiste[0] = true;
            }
        });

        if(participanteExiste[0]){
            System.out.println("El participante ya está registrado, no pudo ser registrado nuevamente.");
        }
        else{
            //asignar el monto según el circuito y la edad
            switch (circuito.getNombre()) {
                case "chico":
                    if (participante.getEdad() < 18) {
                        monto = 1300.0;
                    } else {
                        monto = 1500.0;
                    }
                    break;
                case "medio":
                    if (participante.getEdad() < 18) {
                        monto = 2000.0;
                    } else {
                        monto = 2300.0;
                    }
                    break;
                case "avanzado":
                    if (participante.getEdad() >= 18) {
                        monto = 2800.0;
                    } else {
                        System.out.println("El participante " + participante.toString() + " no fue inscrito a la categoría avanzada debido a que es menor de edad");
                    }
                    break;
            }
            if (monto != 0.0) {
                System.out.println("Participante " + participante.toString() + " inscrito correctamente abonando: " + monto);
                inscripcionesFormalizadas.put(numero, new Inscripcion(numero, circuito, participante, monto));
            }
        }
    }

    public static void Desinscribir(int numero){
        if(inscripcionesFormalizadas.get(numero) != null){
            inscripcionesFormalizadas.remove(numero);
            System.out.println("Inscripción "+numero+" eliminada, lista resultante:");
            for (Inscripcion inscripcion : inscripcionesFormalizadas.values()) {
                System.out.println(inscripcion.toString());
            }
        }else{
            System.out.println("No se puede Desincribir porque el registro no existe");
        }
    }

    public static void MostrarInscritos(Categorias categoria){
        switch (categoria){
            case chico:
                System.out.println("Inscripciones en circuito Chico:");
                for (Inscripcion inscripcion : inscripcionesFormalizadas.values()) {
                    if (inscripcion.getCategoria().getNombre().equals("chico")) {
                        System.out.println(inscripcion);
                    }
                }
                break;
            case medio:
                System.out.println("Inscripciones en circuito Medio:");
                for (Inscripcion inscripcion : inscripcionesFormalizadas.values()) {
                    if (inscripcion.getCategoria().getNombre().equals("medio")) {
                        System.out.println(inscripcion);
                    }
                }
                break;
            case avanzado:
                System.out.println("Inscripciones en circuito Avanzado:");
                for (Inscripcion inscripcion : inscripcionesFormalizadas.values()) {
                    if (inscripcion.getCategoria().getNombre().equals("avanzado")) {
                        System.out.println(inscripcion);
                    }
                }
                break;
        }
    }

    public static void MostrarRecaudacion(){
        double[] recaudacion = new double[3];

        inscripcionesFormalizadas.forEach((integer, inscripcion) -> {
            switch (inscripcion.getCategoria().getNombre()){
                case "chico":
                    recaudacion[0] += inscripcion.getMonto();
                    break;
                case "medio":
                    recaudacion[1] += inscripcion.getMonto();
                    break;
                case "avanzado":
                    recaudacion[2] += inscripcion.getMonto();
                    break;
            }
        });

        System.out.println("Recaudación de circuito Chico: "+recaudacion[0]);
        System.out.println("Recaudación de circuito Medio: "+recaudacion[1]);
        System.out.println("Recaudación de circuito Avanzado: "+recaudacion[2]);
        System.out.println("Recaudación total del Evento: "+(recaudacion[0]+recaudacion[1]+recaudacion[2]));
    }
}

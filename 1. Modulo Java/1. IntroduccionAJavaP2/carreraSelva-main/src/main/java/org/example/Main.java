package org.example;

import java.text.MessageFormat;
import java.util.*;

import org.example.entidades.Circuito;
import org.example.entidades.Inscripcion;
import org.example.entidades.Participante;

public class Main {

    public static void mostrarInscripcionesPorCategoria(List<Inscripcion> listaInscripciones, String categoria){
        for(Inscripcion inscripcion: listaInscripciones){
            if(inscripcion.getCircuito() != null){
                if(inscripcion.getCircuito().getNombre().equals(categoria)){
                    System.out.println(inscripcion);
                }
            }
        }
    }

    public static int calcularMontoInscripcion(Inscripcion inscripcion){
        if(inscripcion.getParticipante() == null){
            return 0;
        }else{
            if(inscripcion.getParticipante().getEdad() > 18){
                return inscripcion.getCircuito().getMontoMayor();
            }else{
                return inscripcion.getCircuito().getMontoMenor();
            }
        }
    }

    public static int calcularMontoTotal(List<Inscripcion> listaIncripciones){
        int sum = 0;
        for(Inscripcion inscripcion: listaIncripciones){
            if(inscripcion.getCircuito() != null){
                sum += calcularMontoInscripcion(inscripcion);
            }
        }
        return sum;
    }

    public static int calcularMontoPorCategoria(List<Inscripcion> listaInscripciones, String categoria){
        int sum = 0;
        for(Inscripcion inscripcion: listaInscripciones){
            if(inscripcion.getCircuito() != null){
                if(inscripcion.getCircuito().getNombre().equals(categoria)){
                    sum += calcularMontoInscripcion(inscripcion);
                }
            }

        }
        return sum;
    }

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
        inscripciones.add(new Inscripcion(1, participantes.get(0), chico));
        inscripciones.add(new Inscripcion(2, participantes.get(1), medio));
        inscripciones.add(new Inscripcion(3, participantes.get(2), avanzado));
        inscripciones.add(new Inscripcion(4, participantes.get(3), medio));
        inscripciones.add(new Inscripcion(4, participantes.get(4), avanzado));

        mostrarInscripcionesPorCategoria(inscripciones, "Circuito Chico");
        mostrarInscripcionesPorCategoria(inscripciones, "Circuito Mediano");
        mostrarInscripcionesPorCategoria(inscripciones, "Circuito Avanzado");
        //Eliminar un participante
        inscripciones.remove(1);
        //Mostrar los participantes nuevamente
        mostrarInscripcionesPorCategoria(inscripciones, "Circuito Mediano");
        //Mostrar Montos
        System.out.println(MessageFormat.format("El monto total de la categoria {0} es {1}","Circuito Chico",calcularMontoPorCategoria(inscripciones, "Circuito Chico")));
        System.out.println(MessageFormat.format("El monto total de la categoria {0} es {1}","Circuito Mediano",calcularMontoPorCategoria(inscripciones, "Circuito Mediano")));
        System.out.println(MessageFormat.format("El monto total de la categoria {0} es {1}","Circuito Avanzado",calcularMontoPorCategoria(inscripciones, "Circuito Avanzado")));
        //Mostrar monto total
        System.out.println(calcularMontoTotal(inscripciones));




    }
}
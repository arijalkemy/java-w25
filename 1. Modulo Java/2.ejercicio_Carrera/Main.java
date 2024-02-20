package org.example;

import org.example.models.Categoria;
import org.example.models.Inscripcion;
import org.example.models.Participante;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear categorías
        Categoria categoriaChico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos.");
        Categoria categoriaMedio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro.");
        Categoria categoriaAvanzado = new Categoria(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        // Crear un nuevo participante e inscribirlo en una categoría
        Participante participante1 = new Participante(1, "1234567890", "Juan", "Pérez", 21, "1234567890", "0987654321", "A+");
        Inscripcion inscripcion1 = new Inscripcion(1, categoriaChico, participante1);

        // Calcular monto de inscripción
        double montoInscripcion1 = inscripcion1.getMonto();

        // Inscribir al azar algunos participantes en diferentes categorías
        Participante participante2 = new Participante(2, "9876543210", "María", "López", 19, "0987654321", "1234567890", "B-");
        Participante participante3 = new Participante(3, "7531592046", "Pedro", "Gómez", 25, "0987654321", "1234567890", "O+");
        Participante participante4 = new Participante(4, "9513578642", "Ana", "Martínez", 18, "0987654321", "1234567890", "AB+");
        Inscripcion inscripcion2 = new Inscripcion(2, categoriaMedio, participante2);
        Inscripcion inscripcion3 = new Inscripcion(3, categoriaChico, participante3);
        Inscripcion inscripcion4 = new Inscripcion(4, categoriaAvanzado, participante4);

        // Agregar las inscripciones a una lista
        List<Inscripcion> listaInscripciones = new ArrayList<>();
        listaInscripciones.add(inscripcion1);
        listaInscripciones.add(inscripcion2);
        listaInscripciones.add(inscripcion3);
        listaInscripciones.add(inscripcion4);

        // Mostrar por pantalla todos los inscriptos a una categoría
        System.out.println("Inscriptos en la categoría " + categoriaChico.getNombre() + ":");
        for (Inscripcion inscripcion : listaInscripciones) {
            if (inscripcion.getCategoria().equals(categoriaChico)) {
                Participante participante = inscripcion.getParticipante();
                System.out.println("Número de inscripción: " + inscripcion.getNumeroInscripcion()
                        + ", Participante: " + participante.getNombre() + " " + participante.getApellido()
                        + ", Edad: " + participante.getEdad());
            }
        }

        // Desinscribir a un participante
        listaInscripciones.remove(inscripcion1);

        // Mostrar cómo queda la lista de inscriptos en la categoría donde se encontraba
        System.out.println("Inscriptos en la categoría " + categoriaChico.getNombre() + " después de la desinscripción:");
        for (Inscripcion inscripcion : listaInscripciones) {
            if (inscripcion.getCategoria().equals(categoriaChico)) {
                Participante participante = inscripcion.getParticipante();
                System.out.println("Número de inscripción: " + inscripcion.getNumeroInscripcion()
                        + ", Participante: " + participante.getNombre() + " " + participante.getApellido()
                        + ", Edad: " + participante.getEdad());
            }
        }

        // Calcular el monto total recaudado por cada categoría y el total de toda la carrera
        double totalRecaudadoChico = 0;
        double totalRecaudadoMedio = 0;
        double totalRecaudadoAvanzado = 0;
        double totalRecaudadoCarrera = 0;

        for (Inscripcion inscripcion : listaInscripciones) {
            double monto = inscripcion.getMonto();
            if (inscripcion.getCategoria().equals(categoriaChico)) {
                totalRecaudadoChico += monto;
            } else if (inscripcion.getCategoria().equals(categoriaMedio)) {
                totalRecaudadoMedio += monto;
            } else if (inscripcion.getCategoria().equals(categoriaAvanzado)) {
                totalRecaudadoAvanzado += monto;
            }
            totalRecaudadoCarrera += monto;
        }

        System.out.println("Monto total recaudado por categoría:");
        System.out.println(categoriaChico.getNombre() + ": $" + totalRecaudadoChico);
        System.out.println(categoriaMedio.getNombre() + ": $" + totalRecaudadoMedio);
        System.out.println(categoriaAvanzado.getNombre() + ": $" + totalRecaudadoAvanzado);
        System.out.println("Total de toda la carrera: $" + totalRecaudadoCarrera);
    }
}
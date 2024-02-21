package main.java.com.bootcamp;

import main.java.com.bootcamp.model.Categoria;
import main.java.com.bootcamp.model.Participante;
import main.java.com.bootcamp.repository.CarreraRepository;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // a) Crear 3 objetos de tipo categoría (uno por cada categoría)
        // con sus respectivos datos.
        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos", 1300.0 , 1500.0 , false);
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro", 2000.0, 2300.0 , false);
        Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra.", -1.0 , 2800.0, true );

        // b) Crear un nuevo participante e inscribirlo en una categoría.
        // Calcular el monto de inscripción que deberá abonar
        // (Por ejemplo: si el participante se inscribe a la categoría Circuito chico
        // y tiene 21 años, el monto a abonar es de $1500).
        Participante pepito = new Participante(1,"234567654","Pepe","Argento", 21, "+54351123456789", "+987856241344556", "A+");
        CarreraRepository carreraRepository = new CarreraRepository();
        carreraRepository.addInscripcion(circuitoChico, pepito);
        // c) Inscribir al azar algunos participantes en diferentes categorías
        // (al menos uno en cada una).
        Participante JuanCarlos = new Participante(1,"234567654","Juan Carlos","Argento", 21, "+54351123456789", "+987856241344556", "A+");
        Participante Eugenio = new Participante(1,"234567654","Eugenio","Argento", 11, "+54351123456789", "+987856241344556", "A+");
        Participante Martin = new Participante(1,"234567654","Martin","Argento", 50, "+54351123456789", "+987856241344556", "A+");
        carreraRepository.addInscripcion(circuitoAvanzado, JuanCarlos);
        carreraRepository.addInscripcion(circuitoAvanzado, Eugenio);
        carreraRepository.addInscripcion(circuitoMedio, Martin);
        // d) Mostrar por pantalla todos los inscriptos a una determinada categoría
        // con sus correspondientes datos y número de inscripción.
        System.out.println("Inscripciones de circuito chico");
        System.out.println( carreraRepository.getParticipantesDeCategoria(circuitoChico));

        // e) Desinscribir a un participante.
        // Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
        System.out.println("desencribiendo a " + pepito.getNombreYApellido());
        carreraRepository.desinscribirParticipante(pepito);
        System.out.println("Lista de inscripciones actualizada:");
        carreraRepository.imprimirInscripciones();
        // f) Calcular el monto total recaudado por cada categoría
        // y el total de toda la carrera incluyendo todas las categorías.

        Map<String, Double> recaudacionePorCategoria =  carreraRepository.getRecaudacionPorCategoria();
        System.out.println("Recaudaciones por categoria");
        System.out.println(recaudacionePorCategoria);
        System.out.println("El total de recaudacion es: ");
        System.out.println("$" + carreraRepository.getTotalRecaudado());
    }
}

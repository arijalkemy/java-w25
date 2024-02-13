import model.Categoria;
import model.Inscripcion;
import model.Participante;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Inscripcion> inscripciones = new ArrayList<>();
        Set<Participante> participantesInscritos = new HashSet<>();

        Categoria chico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos");
        Categoria medio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro");
        Categoria avanzado = new Categoria(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        Participante participanteUno = new Participante("12312312", "Gomez", "Lucas", "A-", "222123212", "123123123", 24, 1);
        Participante participanteDos = new Participante("12312312", "Cabello", "Mateo", "A-", "222123212", "123123123", 10, 2);
        Participante participanteTres = new Participante("12312312", "Petterson", "Claudia", "A-", "222123212", "123123123", 24, 3);
        Participante participanteCuatro = new Participante("12312312", "Petterson", "Carlos", "A-", "222123212", "123123123", 24, 3);

//        inscripciones.add(new Inscripcion(1, chico, participanteUno));
//        inscripciones.add(new Inscripcion(2, medio, participanteDos));
//        inscripciones.add(new Inscripcion(4, medio, participanteCuatro));
//        inscripciones.add(new Inscripcion(3, avanzado, participanteTres));
        inscribir(participantesInscritos, participanteUno,inscripciones,1, chico);
        inscribir(participantesInscritos, participanteDos,inscripciones,2, medio);
        inscribir(participantesInscritos, participanteTres,inscripciones,3, medio);
        inscribir(participantesInscritos, participanteCuatro,inscripciones,4, avanzado);
        inscribir(participantesInscritos, participanteUno,inscripciones,6, avanzado);
        
        //Muestro todas las inscripciones
        System.out.println("----- Lista completa de inscripciones -----");
        inscripciones.forEach(System.out::println);

        //Muestro los inscriptos en la categoria circuito medio
        System.out.println("----- Lista inscriptos en el circuito medio -----");
        inscripciones.stream()
                .filter(inscripcion -> inscripcion.getCategoria().getId() == 2)
                .forEach(System.out::println);

        //Elimino el de circuito medio y muestro como queda la lista de circuito medio
        System.out.println("----- Lista inscriptos en el circuito medio actualizada -----");
        inscripciones.remove(1);
        inscripciones.stream()
                .filter(inscripcion -> inscripcion.getCategoria().getId() == 2)
                .forEach(System.out::println);

        //Calculo el monto total recaudado por categoría y el total de todas
        double totalChico = calcularMonto(inscripciones, 1);
        double totalMedio = calcularMonto(inscripciones, 2);
        double totalAvanzado = calcularMonto(inscripciones, 3);
        System.out.println("El monto total recaudado por el circuito chico es: " + totalChico);
        System.out.println("El monto total recaudado por el circuito medio es: " + totalMedio);
        System.out.println("El monto total recaudado por el circuito avanzado es: " + totalAvanzado);
        System.out.println("El monto total recaudado por todos es: " + (totalChico + totalMedio + totalAvanzado));
    }
    public static double calcularMonto(List<Inscripcion> lista, int categoria){
        return lista.stream()
                .filter(inscripcion -> inscripcion.getCategoria().getId() == categoria)
                .mapToDouble(Inscripcion::calcularMonto).sum();
    }
    public static void inscribir(Set<Participante> participantesInscritos, Participante participante, List<Inscripcion> inscripciones, int id, Categoria categoria){
        if (participantesInscritos.add(participante)) {
            inscripciones.add(new Inscripcion(id, categoria, participante));
            System.out.println("Inscripción exitosa");
        } else {
            System.out.println("El participante ya se encuentra inscrito");
        }
    }
}

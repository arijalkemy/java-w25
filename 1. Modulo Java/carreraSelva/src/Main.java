import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static int numeroDeParticipante = 1;


    public static void main(String[] args) {
        Participante p1 = new Participante(siguienteNumeroParticipante(), "1234", "Jaun", "Perez", 31, "1234", "1234", "-0");
        Participante p2 = new Participante(siguienteNumeroParticipante(), "1234", "Maria", "Lopez", 16, "1234", "1234", "-0");
        Participante p3 = new Participante(siguienteNumeroParticipante(), "1234", "Timmy", "Gonzales", 22, "1234", "1234", "-0");

        List<Circuito> circuitos = new ArrayList<>();
        Circuito circuitoChico = new CircuitoChico(1, "Circuito chico", "2 km por selva y arroyos");
        Circuito circuitoMedio = new CircuitoMedio(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Circuito circuitoAvanzado = new CircuitoAvanzado(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");
        circuitos.add(circuitoChico);
        circuitos.add(circuitoMedio);
        circuitos.add(circuitoAvanzado);

        SistemaDeInscripciones si = new SistemaDeInscripciones(circuitos);

        si.inscribir(circuitoChico, p1);
        si.inscribir(circuitoMedio, p2);
        si.inscribir(circuitoAvanzado, p3);

        si.mostrarInscriptos(circuitoChico);
        si.mostrarInscriptos(circuitoMedio);
        si.mostrarInscriptos(circuitoAvanzado);

        si.mostrarInscriptos(circuitoChico);

        si.desinscribir(p1);

        si.mostrarInscriptos(circuitoChico);

        si.inscribir(circuitoChico, p1);

        si.mostrarMontosRecaudados();
    }

    private static int siguienteNumeroParticipante() {
        return ++numeroDeParticipante;
    }
}
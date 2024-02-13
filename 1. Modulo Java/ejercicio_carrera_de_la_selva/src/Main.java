import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Map<Circuito, Inscripcion> inscripciones = new HashMap<>();

        Circuito circuitoChico = new Circuito(0, "circuito chico", "2 km por selva y arroyos");
        circuitoChico.setMontoMenores(1300);
        circuitoChico.setMontoMayores(1500);
        Circuito circuitoMedio = new Circuito(1, "circuito medio", "5 km por selva, arroyos y barro");
        circuitoMedio.setMontoMenores(2000);
        circuitoMedio.setMontoMayores(2300);
        Circuito circuitoAvanzado = new CircuitoAvanzado(2, "circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");
        circuitoAvanzado.setMontoMayores(2800);

        System.out.println(RepoInscripciones.getInstance().getInscripciones().size());
        Inscripcion inscripcionFulano =  new Inscripcion();
        Inscripcion inscripcionFulano2 =  new Inscripcion();
        Participante fulano = new Participante(44208598, "Fulano", "De Tal", "1124730290", 21, "11111", "0");
        inscripcionFulano.incribirParticipante(fulano);
        inscripcionFulano.escogerCircuito(circuitoChico); // me tiene que dejar
        inscripcionFulano.abonarMontoParticipante(2000); // me tiene que dejar
        System.out.println(RepoInscripciones.getInstance().getInscripciones().size());
        inscripcionFulano2.incribirParticipante(fulano);
        inscripcionFulano2.escogerCircuito(circuitoMedio); // no tiene que dejar
        inscripcionFulano2.abonarMontoParticipante(3000); // rompio
        System.out.println(RepoInscripciones.getInstance().getInscripciones().size());


    }
}
import java.util.*;
import java.util.stream.Collectors;

public class Inscripcion {
    private int numero;
    private Circuito circuito;
    private Participante participante;
    private double monto;

    // Constructor vacio

    public void incribirParticipante (Participante participante) {
        this.participante = participante;
    }

    public void escogerCircuito (Circuito circuito) {
        this.circuito = circuito;
        List<Inscripcion> inscripciones = RepoInscripciones.getInstance()
                .getInscripciones()
                .stream()
                .filter(inscripcion -> inscripcion.getParticipante().getDni() == this.participante.getDni()
                        && inscripcion.getCircuito().getId() != this.circuito.getId())
                .toList();
        if (!inscripciones.isEmpty()) throw new RuntimeException("Ya se encuentra inscripto en un circuito de otra categoria");
        RepoInscripciones.getInstance().getInscripciones().add(this);
    }

    public void abonarMontoParticipante (double monto) {
        double montoCircuito = circuito.calcularMonto(participante.getEdad());
        if (montoCircuito > monto) throw new RuntimeException("El valor ingresado no completa el pago");
        else this.monto = monto;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Circuito getCircuito() {
        return circuito;
    }
}

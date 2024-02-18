import java.util.Objects;

public class Inscripcion {
    CircuitoChico circuitoChico;
    CircuitoMedio circuitoMedio;
    CircuitoAvanzado circuitoAvanzado;

    public Inscripcion(CircuitoChico circuitoChico, CircuitoMedio circuitoMedio, CircuitoAvanzado circuitoAvanzado) {
        this.circuitoChico = circuitoChico;
        this.circuitoMedio = circuitoMedio;
        this.circuitoAvanzado = circuitoAvanzado;
    }

    public void inscribirParticipante(Participante participante, String circuito) {
        if (Objects.equals(circuito, "avanzado") && participante.edad < 18) {
            System.out.println("El participante es menor de edad");
            return;
        }
        if (circuitoChico.participantes.contains(participante)
            && circuitoMedio.participantes.contains(participante)
            && circuitoAvanzado.participantes.contains(participante)) {
            System.out.println("El participante ya esta inscripto en otra categoria");
        }
        else {
            switch (circuito) {
                case "chico":
                    this.circuitoChico.agregarParticipante(participante);
                    System.out.println("El precio de la inscripcion es " + (participante.edad >= 18 ? circuitoChico.precioMayores : circuitoChico.precioMenores));
                    break;
                case "medio":
                    this.circuitoMedio.agregarParticipante(participante);
                    System.out.println("El precio de la inscripcion es " + (participante.edad >= 18 ? circuitoMedio.precioMayores : circuitoMedio.precioMenores));
                    break;
                case "avanzado":
                    this.circuitoAvanzado.agregarParticipante(participante);
                    System.out.println("El precio de la inscripcion es " + circuitoAvanzado.precioMayores);
                    break;
                default:
                    System.out.println("No es un circuito valido");
                    break;
            }
        }
    }
}

package src.categoria;

import src.Participante;

public class Avanzado extends Categoria {

    public Avanzado(int distancia, String descripcion, int precioMayor) {
        super(distancia, descripcion, precioMayor);
    }

    @Override
    public void inscribirParticipante(Participante participante) {
        if (participante.getEdad() > 18) {
            super.inscribirParticipante(participante);
        }
        System.out.printf("\nEl participante numero %s es menor de edad y no tiene permitido perticipar en la categoria de avanzado", participante.getNumeroParticipante());
    }


}

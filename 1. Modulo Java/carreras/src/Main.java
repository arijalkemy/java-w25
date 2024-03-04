// La competencia cuenta con 3 categorías dependiendo de su dificultad y de ellas se guarda una id, el nombre y una
// breve descripción:
//Circuito chico: 2 km por selva y arroyos.
//Circuito medio: 5 km por selva, arroyos y barro.
//Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
public class Main {

    public static void main(String[] args) {
        Participante participante1 = new Participante(1, "11111", "sergio", 10);
        Circuito circuitoChico = new Circuito(1,"chico", "esto es carrera chico");

        Incripcion inscripcion = new Incripcion(1,"chico", participante1,0);

        inscripcion.incribirse(participante1);

    }
}

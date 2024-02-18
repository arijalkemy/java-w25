import java.util.List;
import java.util.ArrayList;

public class Categoria {
    int distancia;
    int precioMayores;
    int precioMenores;
    String recorrido;
    List<Participante> participantes = new ArrayList<>();

    public Categoria(int distancia, int precioMayores, int precioMenores, String recorrido) {
        this.distancia = distancia;
        this.precioMenores = precioMenores;
        this.precioMayores = precioMayores;
        this.recorrido = recorrido;
    }

    public Categoria(int distancia, int precioMayores, String recorrido) {
        this.distancia = distancia;
        this.precioMenores = 0;
        this.precioMayores = precioMayores;
        this.recorrido = recorrido;
    }

    public int calcularRecaudacion() {
        int recaudacion = 0;
        for(Participante p: participantes) {
            if (p.edad >= 18) {
                recaudacion += precioMayores;
            }
            else {
                recaudacion += precioMenores;
            }
        }
        return recaudacion;
    }

    public void agregarParticipante(Participante participante) {
        this.participantes.add(participante);
    }

    public void mostrarParticipantes() {
        for (Participante p : participantes) {
            System.out.printf("Num. Participante: %d. DNI: %d. Nombre: %s. Apellido: %s\n", p.numParticipante, p.dni, p.nombre, p.apellido);
        }
    }

    public void quitarParticipante(int numParticipante) {
        for (int i = 0; i < participantes.size(); i ++) {
            if (participantes.get(i).numParticipante == numParticipante) participantes.remove(i);
        }
    }
}



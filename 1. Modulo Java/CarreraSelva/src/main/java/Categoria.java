import java.util.*;

public class Categoria {

    int distancia;
    int precioMayor;
    int precioMenor;
    String recorrido;
    HashSet<Participante> participantes = new HashSet<>();

    public Categoria(int distancia, int precioMayor, int precioMenor, String recorrido) {

        this.distancia = distancia;
        this.precioMayor = precioMayor;
        this.precioMenor = precioMenor;
        this.recorrido = recorrido;

    }

    public Categoria(int distancia, int precioMayor, String recorrido) {
        this.distancia = distancia;
        this.precioMayor = precioMayor;
        this.recorrido = recorrido;
    }

    public int getDistancia() {
        return distancia;
    }

    public void addParticipante(Participante p1) {
        participantes.add(p1);
    }

    public void getParticipantes() {
        if (!participantes.isEmpty()) {
            for(Participante participante : participantes) {
                System.out.println("-------------------------");
                System.out.println("Número de participante: " + participante.numeroParticipante);
                System.out.println("Nombres: " + participante.nombre + " " + participante.apellido);
                System.out.println("Edad: " + participante.edad);
                System.out.println("Grupo sanguíneo: " + participante.grupoSanguineo);
            }
        } else {
            System.out.println("No hay participantes en esta categoría");
        }

    }

    public void getBeneficios() {
        int beneficios = 0;

        for(Participante participante : participantes) {
            if(participante.getEdad() > 18) {
                beneficios += this.precioMayor;
            } else {
                beneficios += this.precioMenor;
            }
        }

        System.out.println("Los ingresos de esta categoría son: $" + beneficios);
    }

    public int getPrecioMayor() {
        return precioMayor;
    }

    public int getPrecioMenor() {
        return precioMenor;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setPrecioMayor(int precioMayor) {
        this.precioMayor = precioMayor;
    }

    public void setPrecioMenor(int precioMenor) {
        this.precioMenor = precioMenor;
    }

}

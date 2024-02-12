package src.categoria;

import src.Participante;

import java.util.HashSet;
import java.util.Set;

public class Categoria {

    private int distancia;
    private String descripcion;
    private int precioMayor;
    private Set<Participante> participantes;

    public Categoria(int distancia, String descripcion, int precioMayor) {
        this.distancia = distancia;
        this.descripcion = descripcion;
        this.precioMayor = precioMayor;
        this.participantes = new HashSet<>();
    }

    public Categoria(int distancia, String descripcion, int precioMayor, Set<Participante> participantes) {
        this.distancia = distancia;
        this.descripcion = descripcion;
        this.precioMayor = precioMayor;
        this.participantes = participantes;
    }

    public void inscribirParticipante(Participante participante) {
        if(!this.participantes.contains(participante)) {
            this.participantes.add(participante);
            System.out.printf("\nParticipante numero %s agregado", participante.getNumeroParticipante());
        } else {
            System.out.printf("\nEl participante numero %s ya esta inscrito a la carrera", participante.getNumeroParticipante());
        }

    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecioMayor() {
        return precioMayor;
    }

    public void setPrecioMayor(int precioMayor) {
        this.precioMayor = precioMayor;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }
}

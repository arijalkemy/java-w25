package org.example.entidades;

public class Inscripcion {
    private long id;
    private Participante participante;
    private Circuito circuito;
    private int monto;

    public Inscripcion(long id, Participante p, Circuito c){
        if(c.getNombre().equals("Circuito Chico") && p.getEdad() < 18){
                this.participante = null;
                this.circuito = null;
                this.monto = 0;
        }else{
            this.participante = p;
            this.circuito = c;
            this.monto = c.obtenerCosto(p.getEdad());
        }
    }

    public int getMonto(){
        return this.monto;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    @Override
    public String toString() {
        if(getParticipante()==null){
            return "No se permiten menores";
        }
        return "Inscripcion{" +
                "id=" + id +
                ", participante=" + participante +
                ", circuito=" + circuito +
                ", monto=" + monto +
                '}';
    }
}

package org.example.entidades;

public class Inscripcion {
    private long id;
    private Participante participante;
    private Circuito circuito;
    private int monto;

    public Inscripcion(long id, Participante p, Circuito c){
        this.participante = p;
        this.circuito = c;
        this.monto = c.obtenerCosto(p.getEdad());
    }

    public int getMonto(){
        return this.monto;
    }


}

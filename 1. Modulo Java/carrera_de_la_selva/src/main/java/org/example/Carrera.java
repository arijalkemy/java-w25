package org.example;

import java.util.List;

public class Carrera {


    private List<Participante> participantes;
    private double totalRecaudado;
    private double totalChico;
    private double totalMedio;
    private double totalAvanzado;


    public Carrera(List<Participante> participantes) {
        this.participantes = participantes;
        this.totalRecaudado = 0;

    }


    public boolean isInscribible(Inscripcion inscripcion){
        if(inscripcion.getCategoria() instanceof CircuitoAvanzado){
            if(inscripcion.getParticipante().getEdad()>=18){
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }

    public void inscribirParticipante(Inscripcion inscripcion){
        if(isInscribible(inscripcion)){
            if(inscripcion.getCategoria() instanceof CircuitoChico){
                totalChico+= inscripcion.getMontoInscripcion();
            }else if(inscripcion.getCategoria() instanceof CircuitoMedio){
                totalMedio+= inscripcion.getMontoInscripcion();

            }else{
                totalAvanzado+=inscripcion.getMontoInscripcion();
            }


            this.participantes.add(inscripcion.getParticipante());
            this.totalRecaudado += inscripcion.getMontoInscripcion();
        }else{
            throw new IllegalArgumentException("No se puede inscribir a menores de 18 años en el Circuito Avanzado");

        }
    }

    public void desinscribirParticipante(Participante participante){
        this.participantes.remove(participante);
    }

    public List<Participante> getParticipantes(){
        return this.participantes;
    }


    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public double getTotalChico() {
        return totalChico;
    }

    public double getTotalMedio() {
        return totalMedio;
    }

    public double getTotalAvanzado() {
        return totalAvanzado;
    }
}

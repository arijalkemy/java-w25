package org.example;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    private int numero;
    private Categoria categoria;
    private Participante participante;




    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMontoInscripcion() {

        if(this.categoria instanceof CircuitoChico){
           if(this.participante.getEdad()>=18) {
               return 1500;
              }else{
                return 1300;
           }
        }else if(this.categoria instanceof CircuitoMedio){
            if(this.participante.getEdad()>=18) {
                return 2300;
            }else{
                return 2000;
            }
        }else{
            if(this.participante.getEdad()>=18) {
                return 2800;
            }else{
               throw new IllegalArgumentException("No se puede inscribir a menores de 18 años en el Circuito Avanzado");
            }
        }

    }




}

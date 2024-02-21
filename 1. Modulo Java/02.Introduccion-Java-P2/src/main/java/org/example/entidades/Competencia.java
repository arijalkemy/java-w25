package org.example.entidades;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Competencia {
    List<Inscripcion> inscripciones = new ArrayList<>();

    public Competencia(List<Inscripcion> inscripciones){
        this.inscripciones = inscripciones;
    }
    
    public void mostrarPorCategoria(int id) {
        System.out.println("mostrando x  categorias");
    }

    public void eliminarParticipante(int idPersona, int id) {
        System.out.println("fulanito eliminado");
    }

    public void calcularTotalPorCategoria(int id) {
        System.out.println("mostrando x categorias");
    }

    private Circuito validarCircuito(int id){
        return null;
    }

}

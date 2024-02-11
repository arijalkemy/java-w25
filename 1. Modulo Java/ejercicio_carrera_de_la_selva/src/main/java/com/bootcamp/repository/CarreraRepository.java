package com.bootcamp.repository;

import com.bootcamp.model.Categoria;
import com.bootcamp.model.Inscripcion;
import com.bootcamp.model.Participante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarreraRepository {
    private List<Inscripcion> inscripciones;

    public CarreraRepository(){
        inscripciones = new ArrayList<>();
    }
    public void addInscripcion(Categoria categoria, Participante participante){
        try {
            Inscripcion inscripcion = new Inscripcion(inscripciones.size(), categoria, participante);
            inscripciones.add(inscripcion);
            System.out.println("inscripcion con exito");
            System.out.println(inscripcion);
        }catch (RuntimeException e){

            System.out.println(e.getMessage());
        }

    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public List<Inscripcion> getParticipantesDeCategoria(Categoria categoria){
        return this.inscripciones.stream().filter(inscripcion -> inscripcion.getCategoria().equals(categoria)).toList();

    }

    public void desinscribirParticipante(Participante participante){
        this.inscripciones = this.inscripciones.stream().filter(inscripcion -> !inscripcion.getParticipante().equals(participante)).toList();

    }

    public void imprimirInscripciones(){
        this.inscripciones.forEach(System.out::println);
    }

    public Map<String, Double> getRecaudacionPorCategoria(){
        Map<String, Double> recaudaciones = new HashMap<>();
        this.inscripciones.forEach(inscripcion ->
                {
                    if (recaudaciones.containsKey(inscripcion.getCategoria().getNombre())){
                        recaudaciones.put(inscripcion.getCategoria().getNombre(), recaudaciones.get(inscripcion.getCategoria().getNombre()) + inscripcion.getMontoAAbonar());
                    }else {
                        recaudaciones.put(inscripcion.getCategoria().getNombre(), inscripcion.getMontoAAbonar());
                    }
                }
            );
        return recaudaciones;
    }

    public Double getTotalRecaudado(){
        return this.inscripciones.stream().mapToDouble(Inscripcion::getMontoAAbonar).sum();
    }

}

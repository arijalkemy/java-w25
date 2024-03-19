package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InscripcionRepository {

    private List<Inscripcion> inscripcionList;

    public InscripcionRepository() {
        this.inscripcionList = new ArrayList<>();
    }

    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void agregarInscripcion(Inscripcion inscripcion){
        this.inscripcionList.add(inscripcion);
    }

    @Override
    public String toString() {
        return "InscripcionRepository{" +
                "inscripcionList=" + inscripcionList +
                '}';
    }

    public void nuevasInscripciones(Category chico, Category medio, Category avanzado){
        agregarInscripcion(new Inscripcion(1,chico,
                new Competitor(1, 23136803, "Jaime", "Rodriguez", 14, 3001238, 3123424,  "0+"), 1300));
        agregarInscripcion(new Inscripcion(1,medio,
                new Competitor(2, 47492109, "Jorge", "Zuluaga", 17, 241245, 7402839,  "0+"), 2000));
        agregarInscripcion(new Inscripcion(1,chico,
                new Competitor(3, 12903709, "Camila", "Polo", 24, 3453534, 4830289,  "0+"), 1500));
        agregarInscripcion(new Inscripcion(1,avanzado,
                new Competitor(4, 47492820, "Tomas", "Montenegro", 25, 312317, 73902829,  "0+"), 2800));
        agregarInscripcion(new Inscripcion(1,medio,
                new Competitor(5, 68604382, "Wilber", "Palencia", 29, 4569064, 9283028,  "0+"), 2300));
        agregarInscripcion(new Inscripcion(1,avanzado,
                new Competitor(6, 90002836, "Sara", "Jimenez", 19, 45650808, 9183700,  "0+"), 2800));
    }

    public void mostrarParticipantesPorCategoria(Category categoriaEvaluar){
        inscripcionList.stream()
                .filter(inscripcion -> inscripcion.getCategoria().equals(categoriaEvaluar))
                .map(Inscripcion::getCompetitor)
                .forEach(System.out::println);
    }

    public void eliminarCompetidorPorId(int id){
        Optional<Inscripcion> competidorAEliminar = inscripcionList.stream()
                .filter(inscripcion -> inscripcion.getCompetitor().getCompetitorId() == id)
                .findFirst();

        competidorAEliminar.ifPresent(inscripcionList::remove);
    }

    public double calcularMontoPorCategoria(Category categoriaEvaluar){
        return inscripcionList.stream()
                .filter(inscripcion -> inscripcion.getCategoria().equals(categoriaEvaluar))
                .mapToDouble(Inscripcion::getTotalPago)
                .sum();
    }

    public double calcularMontoTotalCarrera(){
        return inscripcionList.stream()
                .mapToDouble(Inscripcion::getTotalPago)
                .sum();
    }

}

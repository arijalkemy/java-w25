package org.example;

public class Main {
    public static void main(String[] args) {

        Methods methods = new Methods();
        InscripcionRepository listaInscripciones = new InscripcionRepository();

        //punto a
        Category circuitChico = methods.createCircuitChico();
        Category circuitMedio = methods.createCircuitMedio();
        Category circuitAvanzado = methods.createCircuitAvanzado();

        //punto b
        Competitor competitor = methods.registerCompetitor(listaInscripciones.getInscripcionList());
        Category circuito = methods.seleccionarCircuito();
        listaInscripciones.agregarInscripcion(new Inscripcion(101, circuito, competitor, methods.evaluateRegistration(circuito,competitor)));

        //punto c
        listaInscripciones.nuevasInscripciones(circuitChico, circuitMedio, circuitAvanzado);
        System.out.println(listaInscripciones);

        //punto d
        listaInscripciones.mostrarParticipantesPorCategoria(circuitChico);
        listaInscripciones.mostrarParticipantesPorCategoria(circuitMedio);
        listaInscripciones.mostrarParticipantesPorCategoria(circuitAvanzado);

        //punto e
        listaInscripciones.eliminarCompetidorPorId(3);
        listaInscripciones.mostrarParticipantesPorCategoria(circuitChico);

        //punto f
        System.out.println("Total de recaudación de la carrera: " + listaInscripciones.calcularMontoTotalCarrera());
        System.out.println("Total de recaudación del circuito avanzado: " + listaInscripciones.calcularMontoPorCategoria(circuitAvanzado));

    }
}
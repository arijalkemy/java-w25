package Ejercicio_Carrera_Selva;

public class Main {
    public static void main(String[] args) throws Exception {
        Categoria circuitoChico = new Categoria(1, "Chico", "2km por selva y arroyos.");
        Categoria circuitoMedio = new Categoria(1, "Medio", "5 km por selva, arroyos y barro.");
        Categoria circuitoAvanzado = new Categoria(1, "Avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        Participante pers1 = new Participante( 1, 12345678, "Juan Manuel", "Pergola",
                                                27, "1134345645", "12345",  "0+");
        Inscripcion inscripcion1 = new Inscripcion(1, "Chico", pers1);
        inscripcion1.calcularMonto();

        Participante pers2 = new Participante( 1, 12345678, "Joan", "Parbola",
                17, "1134345645", "12345",  "0+");
        Inscripcion inscripcion2 = new Inscripcion(1, "Medio", pers2);
        inscripcion2.calcularMonto();

        Participante pers3 = new Participante( 1, 12345678, "Matias", "Bagguete",
                20, "1134345645", "12345",  "0+");
        Inscripcion inscripcion3 = new Inscripcion(1, "Avanzado", pers3);
        inscripcion3.calcularMonto();
        Participante pers4 = new Participante( 2, 12345678, "Nicolas", "Lopen",
                21, "1134345645", "12345",  "0+");
        Inscripcion inscripcion4 = new Inscripcion(2, "Avanzado", pers4);
        inscripcion4.calcularMonto();

        circuitoChico.agregarInscripto(inscripcion1);
        circuitoMedio.agregarInscripto(inscripcion2);
        circuitoAvanzado.agregarInscripto(inscripcion3);
        circuitoAvanzado.agregarInscripto(inscripcion4);

        mostrarParticipantesCircuito(circuitoChico, "Chico");
        mostrarParticipantesCircuito(circuitoMedio, "Medio");
        mostrarParticipantesCircuito(circuitoAvanzado, "Avanzado");

        circuitoAvanzado.removerInscripcion(inscripcion4);
        System.out.println("Se desinscribio al participante: " + pers4.getNombre());
        mostrarParticipantesCircuito(circuitoAvanzado, "Avanzado");

        double montoFinalCarrera = 0;

        double montoCategChico = circuitoChico.calcularMontoTotal();
        System.out.println("Monto recaudado categoria chico: " + montoCategChico);
        montoFinalCarrera += montoCategChico;

        double montoCategMedio = circuitoMedio.calcularMontoTotal();
        System.out.println("Monto recaudado categoria medio: " + montoCategMedio);
        montoFinalCarrera += montoCategMedio;

        double montoCategAvanzado = circuitoAvanzado.calcularMontoTotal();
        System.out.println("Monto recaudado categoria avanzado: " + montoCategAvanzado);
        montoFinalCarrera += montoCategAvanzado;

        System.out.println("Monto final recaudado de la carrera: " + montoFinalCarrera);
    }

    public static void mostrarParticipantesCircuito(Categoria circuito, String tipoCateg) {
        System.out.println("INSCRIPTOS CIRCUITO " + tipoCateg.toUpperCase());
        System.out.println("-------------------------");
        for(Inscripcion ins : circuito.getInscripciones()) {
            System.out.println(ins);
        }
        System.out.println();
    }
}

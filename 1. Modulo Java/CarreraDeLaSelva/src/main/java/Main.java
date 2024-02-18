public class Main {
    public static void main(String[] args) {

        CircuitoChico circuitoChico = new CircuitoChico(2, 1500, 1300, "Selva y arroyos");
        CircuitoMedio circuitoMedio = new CircuitoMedio(5, 2300, 2000, "Selva, arroyos y barro");
        CircuitoAvanzado circuitoAvanzado = new CircuitoAvanzado(10, 2800, "Selva, arroyos, barro y escalada en piedra");

        Participante partipante1 = new Participante(1, 12345678, "Felipe", "Gomez", 20, 11234578, 11322323, "0+");
        Participante partipante2 = new Participante(2, 13264487, "Juan", "Perez", 22, 11234578, 11322323, "0+");
        Participante partipante3 = new Participante(3, 19123458, "Luis", "Miguel", 33, 11234578, 11322323, "0+");
        Participante partipante4 = new Participante(4, 21164981, "Facundo", "Castro", 22, 11234578, 11322323, "0+");
        Participante partipante5 = new Participante(5, 33263587, "Pepe", "Argento", 43, 11234578, 11322323, "0+");
        Participante partipanteMenorDeEdad = new Participante(6, 20378118, "Carlos", "Gonzalez", 17, 11234578, 11322323, "0+");

        Inscripcion inscripcion = new Inscripcion(circuitoChico, circuitoMedio, circuitoAvanzado);

        System.out.println("\n----------------------------");
        System.out.println("Inscribir participante en circuito chico. Calcular el monto de inscripción que deberá abonar:");
        inscripcion.inscribirParticipante(partipante1, "chico");
        inscripcion.inscribirParticipante(partipante2, "chico");
        
        System.out.println("\n----------------------------");
        System.out.println("Inscribir participante en circuito medio. Calcular el monto de inscripción que deberá abonar:");
        inscripcion.inscribirParticipante(partipante3, "medio");
        inscripcion.inscribirParticipante(partipante4, "medio");

        System.out.println("\n----------------------------");
        System.out.println("Inscribir participante en circuito avanzado. Calcular el monto de inscripción que deberá abonar:");
        inscripcion.inscribirParticipante(partipante5, "avanzado");
        inscripcion.inscribirParticipante(partipanteMenorDeEdad, "avanzado");

        System.out.println("\n----------------------------");
        System.out.println("Mostrar participantes del circuito chico:");
        circuitoChico.mostrarParticipantes();

        System.out.println("\n----------------------------");
        System.out.println("Mostrar participantes del circuito medio:");
        circuitoMedio.mostrarParticipantes();

        System.out.println("\n----------------------------");
        System.out.println("Mostrar participantes del circuito avanzado:");
        circuitoAvanzado.mostrarParticipantes();

        System.out.println("\n----------------------------");
        System.out.println("Desinscribir un participante. Mostar como queda la lista de participantes:");
        circuitoChico.quitarParticipante(1);
        circuitoChico.mostrarParticipantes();

        System.out.println("\n----------------------------");
        System.out.println("Calcular la recaudacion de un circuito:");
        System.out.println(circuitoChico.calcularRecaudacion());

        System.out.println("\n----------------------------");
        System.out.println("Calcular la recaudacion de toda la carrera:");
        System.out.println(circuitoChico.calcularRecaudacion() + circuitoMedio.calcularRecaudacion() + circuitoAvanzado.calcularRecaudacion());
    }
}

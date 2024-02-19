public class Main {
    public static void main(String[] args) {
        Categoria circuitoChico = new Categoria(
                1,
                "Circuito chico",
                "2 km por selva y arroyos"
        ), circuitoMedio = new Categoria(
                2,
                "Circuito medio",
                "5 km por selva, arroyos y barro"
        ), circuitoAvanzado = new Categoria(
                3,
                "Circuito avanzado",
                "10 km por selva, arroyos, barro y escalada en piedra"
        );

        Participante primerParticipante = new Participante(
                1,
                "David",
                "Cardona",
                21,
                300000000,
                300000000,
                "O+"
        ), segundoParticipante = new Participante(
                2,
                "Samuel",
                "Villegas",
                17,
                300000000,
                300000000,
                "O-"
        ), tercerParticipante = new Participante(
                3,
                "Julian",
                "Giraldo",
                17,
                300000000,
                300000000,
                "O+"
        ),cuartoParticipante = new Participante(
                1,
                "Superman",
                "Ken",
                19,
                300000000,
                300000000,
                "O+"
        );


        Inscripcion inscripcionPrimerParticipante = new Inscripcion(
                1,
                circuitoChico,
                primerParticipante
        ), inscripcionSegundoParticipante = new Inscripcion(
                2,
                circuitoMedio,
                segundoParticipante
        ), inscripcionTercerParticipante = new Inscripcion(
                3,
                circuitoAvanzado,
                tercerParticipante
        ), inscripcionCuartoParticipante = new Inscripcion(
                4,
                circuitoAvanzado,
                cuartoParticipante
        );

        System.out.println("\n Ejercicio ---b---");
        System.out.printf("El primer participante debera pagar: %d", inscripcionPrimerParticipante.getMontoAbonar());
        System.out.println();

        System.out.println("\n Ejercicio ---d---");
        System.out.println("Inscritos primera categoría (Circuito chico):");
        for (int i = 0; i < circuitoChico.getParticipantesInscritos().size(); i++) {
            System.out.printf("%d: %s\n", i + 1, circuitoChico.getParticipantesInscritos().get(i).getParticipante().toString());
        }

        System.out.println("\nInscritos segunda categoría (Circuito medio):");
        for (int i = 0; i < circuitoMedio.getParticipantesInscritos().size(); i++) {
            System.out.printf("%d: %s\n", i + 1, circuitoMedio.getParticipantesInscritos().get(i).getParticipante().toString());
        }

        System.out.println("\nInscritos tercera categoría (Circuito avanzado):");
        for (int i = 0; i < circuitoAvanzado.getParticipantesInscritos().size(); i++) {
            System.out.printf("%d: %s\n", i + 1, circuitoAvanzado.getParticipantesInscritos().get(i).getParticipante().toString());
        }

        System.out.println("\n Ejercicio ---e---");
        inscripcionTercerParticipante.eliminarInscripcion();
        for (int i = 0; i < circuitoAvanzado.getParticipantesInscritos().size(); i++) {
            System.out.printf("%d: %s\n", i + 1, circuitoAvanzado.getParticipantesInscritos().get(i).getParticipante().toString());
        }

        System.out.println("\n================ TAREA F ================");
        int recaudoChico = circuitoChico.calcularRecaudo(),
                recaudoMedio = circuitoMedio.calcularRecaudo(),
                recaudoAvanzado = circuitoAvanzado.calcularRecaudo();
        System.out.printf("Recaudo primera categoría (Circuito chico): %d\n", recaudoChico);
        System.out.printf("Recaudo segunda categoría (Circuito medio): %d\n", recaudoMedio);
        System.out.printf("Recaudo tercera categoría (Circuito avanzado): %d\n", recaudoAvanzado);
        System.out.printf("Total recaudado en todas las categorías: %d\n", (recaudoChico + recaudoMedio + recaudoAvanzado));
    }

}

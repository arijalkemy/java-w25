package src;

import src.categoria.Avanzado;
import src.categoria.Categoria;
import src.categoria.Chico;
import src.categoria.Medio;

public class P2Main {

    public static void main(String[] args) {


        Categoria categoriaChico =
                new Chico(2, "Selva y arrollos", 1300, 1500);
        Categoria categoriaMedio =
                new Medio(5, "Selva, arrollos y barro", 2000, 2300);
        Categoria categoriaAvanzado =
                new Avanzado(10, "Selva, arrollos, barro y escalada en piedra", 2800);

        Participante participante = new Participante(
                001,
                "randomDNI001",
                "Jonathan",
                "Pinilla",
                25,
                "324234243",
                "3345345345",
                "O+"
        );

        Participante participante2 = new Participante(
                002,
                "randomDNI002",
                "Nicolas",
                "Pinilla",
                17,
                "1234785",
                "0934879823",
                "O+"
        );

        categoriaChico.inscribirParticipante(participante);
        categoriaChico.inscribirParticipante(participante);
        categoriaAvanzado.inscribirParticipante(participante2);

        System.out.printf("\nParticipantes de la categoria chico: %s", categoriaChico.getParticipantes());
        System.out.printf("\n\nParticipantes de la categoria medio: %s", categoriaMedio.getParticipantes());
        System.out.printf("\n\nParticipantes de la categoria avanzado: %s", categoriaAvanzado.getParticipantes());

    }

}

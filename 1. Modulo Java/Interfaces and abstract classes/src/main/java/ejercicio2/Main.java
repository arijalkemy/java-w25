package ejercicio2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Documento libro = new Libros(
                80,
                "Libro 1",
                "Autor 1",
                "Titulo Libro",
                "Acción"
        );

        Documento informe = new Informe("lorem", 15, "Juan Neruda", "Dario Dali");
        Documento curriculum = new Curriculum(
                "Juan Lozano",
                123456,
                "Bogotá",
                "Desarrollador",
                16,
                List.of("Git", "Vscode")
                );

        Imprimible.imprimir(libro);
        Imprimible.imprimir(informe);
        Imprimible.imprimir(curriculum);
    }

}

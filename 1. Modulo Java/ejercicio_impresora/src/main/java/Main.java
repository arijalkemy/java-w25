import interfaces.Imprimible;
import model.Curriculum;
import model.Informe;
import model.LibroPDF;
import model.Persona;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona(
                "Ramiro",
                "12312312",
                Arrays.asList("Java", "Git")
        );

        Curriculum curriculum = new Curriculum(persona);
        Informe informe = new Informe(
                "Este es un informe sobre...",
                "Ramiro",
                "Victoria",
                21
        );
        LibroPDF libro = new LibroPDF(
                673,
                "J.K.Rowling",
                "Harry Potter",
                "Fantasía"
        );

        imprimir(curriculum);
        imprimir(informe);
        imprimir(libro);

    }
    /* Este método está bien ubicado acá?? */
    public static void imprimir(Imprimible archivo){
        archivo.imprimir();
    }
}

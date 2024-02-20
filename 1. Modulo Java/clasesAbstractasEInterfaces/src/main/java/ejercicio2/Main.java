package ejercicio2;

import ejercicio2.clases.Informes;
import ejercicio2.clases.LibrosPDF;
import ejercicio2.clases.curriculum;
import ejercicio2.clases.Imprimible;

public class Main {
    public static void main(String[] args) {
        LibrosPDF libro = new LibrosPDF("Aventura",54,"Carlos Sanchez","Las aventuras de mathew");
        //curriculum curriculum = new curriculum("Jose","Gutierrez","12345678",21);
        Informes informe = new Informes("Lorem ipsum sit amet",4,"Carlos Sanchez","Omar Rodriguez");

        /*curriculum.agregarHabilidades("Proactivo");
        curriculum.agregarHabilidades("Responsable");
        curriculum.agregarHabilidades("Creativo");
        curriculum.agregarHabilidades("Organizado");*/

        //Imprimible.imprimirDocumento(curriculum);
        Imprimible.imprimirDocumento(libro);
        Imprimible.imprimirDocumento(informe);


    }
}

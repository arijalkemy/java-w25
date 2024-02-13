package org.example.ejercicio_2_documentos;

import org.example.ejercicio_2_documentos.auxiliares.Persona;
import org.example.ejercicio_2_documentos.documento.Curriculum;
import org.example.ejercicio_2_documentos.documento.Documento;
import org.example.ejercicio_2_documentos.documento.Informe;
import org.example.ejercicio_2_documentos.documento.LibroPDF;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Documentos {
    public static void main(String[] args) {

        //sala10 - 02-02-24

        System.out.println("************************");

        ArrayList<String> habilidadesNahuel = new ArrayList<>(Arrays.asList("Java", "SQL", "Spring", "Microservicios"));
        Documento curriculum = new Curriculum(1,
                new Persona("Nahuel Quilpatay", 20, 45244598, habilidadesNahuel));
        curriculum.imprimir();

        System.out.println("************************");

        Documento informe = new Informe(567, "Nachuchi Q.", "Victor H.",
                "Hola esto es un informe.");
        informe.imprimir();

        System.out.println("************************");

        Documento libroPDF = new LibroPDF(836, "Quentin T.", "J.C. Van Damme", "Acción");
        libroPDF.imprimir();

        /*
        * Ejercicio 3
        Se solicita la creación de una clase abstracta denominada Animal, de la cual deriven 3 animales:
        * Perro, Gato y Vaca. Los 3 animales son capaces de “emitir sonidos”, para ello será necesario implementar
        * un método que permita mostrar por pantalla el sonido que emite cada animal. Por ejemplo, en el caso del
        * perro “guau”, el gato “miau” y la vaca “muuu”.

        A partir de esto, teniendo en cuenta los gustos alimenticios de cada animal (gato y perro son considerados
        * carnívoros y la vaca un hervíboro), incluir las interfaces necesarias para contemplar los métodos comerCarne
        * o comerHierba.

        Una vez realizado lo mencionado, llevar a cabo en el Main la creación de diferentes animales y la invocación
        * de sus respectivas implementaciones de métodos.


        Como propuesta extra se sugiere llamar a un método comerAnimal donde a partir del pasaje de un objeto de
        * cualquier tipo de animal como parámetro, invoque al método para comer según corresponda a dicho animal.
        * */
    }
}

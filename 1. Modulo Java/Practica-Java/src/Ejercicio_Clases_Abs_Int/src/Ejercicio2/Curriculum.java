package Ejercicio_Clases_Abs_Int.src.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements IImprimible {
    private Persona empleado;
    List<String> habilidades;

    public Curriculum(Persona empleado, ArrayList<String> habilidades) {
        this.empleado = empleado;
        this.habilidades = habilidades;
    }

    public void imprimir() {
        System.out.println("Imprimiendo Curriculum...");
    }
}

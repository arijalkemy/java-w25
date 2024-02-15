package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Documento{
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private List<String> habilidades = new ArrayList<>();

    @Override
    public void imprimir() {
        imprimirTipoDoc(); // Utiliza este metodo ya que la clase Curriculum extiende de Documento
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Dni: " + dni);
        System.out.println("Edad: " + edad);
        for (String habilidad : habilidades) {
            System.out.println("Habilidad: " + habilidad);
        }
    }
}

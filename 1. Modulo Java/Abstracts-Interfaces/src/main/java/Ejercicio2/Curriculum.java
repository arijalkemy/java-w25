package Ejercicio2;

import java.util.List;

public class Curriculum extends Documento{
    private String nombre;
    private String apellido;
    private String dni;
    List<String> habiilidades;

    public Curriculum(String nombre, String apellido, String dni, List<String> habiilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.habiilidades = habiilidades;
    }

    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Habilidades: " + habiilidades.toString());
    }
}

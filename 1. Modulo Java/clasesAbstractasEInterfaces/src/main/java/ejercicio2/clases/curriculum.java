package ejercicio2.clases;

import java.util.ArrayList;

public class curriculum extends Documentos{

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private ArrayList<String> habilidades;

    public curriculum(String nombre, String apellido, String dni, int edad, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = habilidades;
    }
    public void agregarHabilidades(String habilidad){
        habilidades.add(habilidad);
    }

    @Override
    public void imprimir(){
        imprimirTipo();
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Dni: " + dni);
        System.out.println("Edad: " + edad);
        for (String habilidad: habilidades) {
            System.out.println("Habilidad: " + habilidad);
        }
    }

    public void imprimirDocumento(Documentos documentos) {

    }

    public void imprimirTipoDoc() {

    }
}

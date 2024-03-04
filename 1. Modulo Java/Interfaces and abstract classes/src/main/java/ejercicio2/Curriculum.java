package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Documento{
    private String nombre;
    private int dni;
    private String ciudad;
    private String cargo;
    private int anosExperiencia;
    private List<String> habilidades = new ArrayList<String>();

    public Curriculum(String nombre, int dni, String ciudad, String cargo, int anosExperiencia, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.dni = dni;
        this.ciudad = ciudad;
        this.cargo = cargo;
        this.anosExperiencia = anosExperiencia;
        this.habilidades = habilidades;
    }


    private String imprimirHabilidades(){
        String textoHabilidades = "";
        for (String habilidad : habilidades) {
            textoHabilidades += habilidad;
        }
        return textoHabilidades;
    }

    @Override
    public String toString() {
        //System.out.println("Imprimiendo curriculum:");
        String s = "Nombre: " + this.nombre +
                "\nDNI: " + this.dni +
                "\nCiudad: " + this.ciudad +
                "\nCargo: " + this.cargo +
                "\nAños de experiencia: " + this.anosExperiencia +
                "\nHabilidades: " + this.imprimirHabilidades();
        return s;
    }


}

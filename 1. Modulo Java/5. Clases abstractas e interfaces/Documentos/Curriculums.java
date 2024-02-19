import java.util.ArrayList;
import java.util.Arrays;

public class Curriculums implements Imprimible{
    String nombre;
    String apellido;
    int edad;
    String profesion;
    private String[] habilidades;

    public Curriculums(String nombre, String apellido, int edad, String profesion, String[] habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.profesion = profesion;
        this.habilidades = habilidades;
    }

    @Override
    public void Imprimir() {
        System.out.println( "Curriculums{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", profesion='" + profesion + '\'' +
                ", habilidades=" + Arrays.toString(habilidades) +
                '}');
    }
}

package bootcamp.ej2;

import java.util.List;

public class Curriculum extends Documento {
    private String nombrePersona;
    private List<String> habilidades;

    public Curriculum(String nombrePersona, List<String> habilidades){
        this.nombrePersona = nombrePersona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombrePersona='" + nombrePersona + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}

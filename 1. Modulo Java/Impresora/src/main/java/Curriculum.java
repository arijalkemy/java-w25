import java.util.List;

public class Curriculum extends Documento {

    private List<String> habilidades;

    public Curriculum(List<String> hab) {
        this.habilidades = hab;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Curriculum");
    }
}

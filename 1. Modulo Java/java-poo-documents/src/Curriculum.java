import java.util.List;

public class Curriculum implements IImprimir{
    private Person person;
    private List<Habilidad> habilidades;

    public Curriculum(Person person, List<Habilidad> habilidades) {
        this.person = person;
        this.habilidades = habilidades;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "person=" + person +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}

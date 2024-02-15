import java.util.List;

public class Curriculum implements Printable{
    private String name;
    private String lastname;
    private List<String> skills;

    public Curriculum(String name, String lastname, List<String> skills) {
        this.name = name;
        this.lastname = lastname;
        this.skills = skills;
    }

    @Override
    public void print() {
        System.out.println("Curriculum{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", skills=" + skills +
                '}'
        );
    }
}

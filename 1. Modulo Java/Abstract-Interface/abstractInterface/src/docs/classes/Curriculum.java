package docs.classes;

import java.util.List;

public class Curriculum extends Document {

    private String personName;
    private Integer personAge;
    private String personCareer;
    private List<String> skills;

    public Curriculum(String personName, Integer personAge, String personCareer, List<String> skills) {
        this.personName = personName;
        this.personAge = personAge;
        this.personCareer = personCareer;
        this.skills = skills;
        type = "Curriculum";
    }


}

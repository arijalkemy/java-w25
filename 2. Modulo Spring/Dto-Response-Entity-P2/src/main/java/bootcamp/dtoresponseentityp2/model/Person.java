package bootcamp.dtoresponseentityp2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private List<Symptom> symptoms;

}

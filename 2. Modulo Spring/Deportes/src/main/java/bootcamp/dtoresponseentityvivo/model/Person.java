package bootcamp.dtoresponseentityvivo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    private String firstName;
    private String lastName;
    private Integer age;
    private List<Sport> sports = new ArrayList<>();

}

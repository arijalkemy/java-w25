package bootcamp.dtoresponseentityp2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Symptom {

    private String code;
    private String name;
    private String severity;

}

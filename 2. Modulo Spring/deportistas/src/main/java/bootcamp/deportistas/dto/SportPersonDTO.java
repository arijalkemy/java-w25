package bootcamp.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportPersonDTO {
    private String namePerson;
    private String lastNamePerson;
    private String nameSport;

}

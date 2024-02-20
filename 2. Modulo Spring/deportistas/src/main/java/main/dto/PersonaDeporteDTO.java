package main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class PersonaDeporteDTO {
    private String namePerson;
    private String nameSport;
}

package covid19.dto;

import covid19.model.Sintoma;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class PersonaDTO {
    String nombre;
    String apellido;
    List<Sintoma> sintomas = new ArrayList<>();
}

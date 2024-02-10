package covid19.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class Sintoma {
    public static List<Sintoma> sintomas = new ArrayList<>() {{
        add(new Sintoma(1, "Fiebre", 3));
        add(new Sintoma(2, "Tos", 3));
        add(new Sintoma(3, "Dolor de cabeza", 2));
        add(new Sintoma(4, "Dolor de garganta", 2));
        add(new Sintoma(5, "Dificultad para respirar", 3));
        add(new Sintoma(6, "Dolor de cuerpo", 1));
        add(new Sintoma(7, "Diarrea", 3));
        add(new Sintoma(8, "Nauseas", 2));
        add(new Sintoma(9, "Vomitos", 3));
        add(new Sintoma(10, "Perdida del olfato", 2));
        add(new Sintoma(11, "Perdida del gusto", 2));
        add(new Sintoma(12, "Dolor de ojos", 1));
        add(new Sintoma(13, "Dolor de oidos", 1));
        add(new Sintoma(14, "Dolor de pecho", 3));
        add(new Sintoma(15, "Dolor de estomago", 2));
    }};
    int codigo;
    String nombre;
    int nivelDeGravedad;
}

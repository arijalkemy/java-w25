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
public class Persona {
    public static List<Persona> personas = new ArrayList<>() {{
        add(new Persona(1, "Juan", "Perez", 20, Sintoma.sintomas.subList(0, 3)));
        add(new Persona(2, "Pedro", "Gomez", 30, Sintoma.sintomas.subList(3, 6)));
        add(new Persona(3, "Maria", "Lopez", 40, Sintoma.sintomas.subList(6, 9)));
        add(new Persona(4, "Jose", "Martinez", 50, Sintoma.sintomas.subList(9, 12)));
        add(new Persona(5, "Ana", "Sanchez", 60, Sintoma.sintomas.subList(12, 15)));
        add(new Persona(6, "Lucia", "Gonzalez", 70, Sintoma.sintomas.subList(0, 0)));
        add(new Persona(7, "Carlos", "Rodriguez", 80, new ArrayList<>()));
        add(new Persona(8, "Marta", "Fernandez", 90, Sintoma.sintomas.subList(0, 3)));
        add(new Persona(9, "Luis", "Diaz", 100, Sintoma.sintomas.subList(3, 6)));
        add(new Persona(10, "Sofia", "Gutierrez", 110, Sintoma.sintomas.subList(6, 9)));
        add(new Persona(11, "Miguel", "Romero", 120, Sintoma.sintomas.subList(9, 12)));
        add(new Persona(12, "Laura", "Alvarez", 130, Sintoma.sintomas.subList(12, 15)));
    }};
    int id;
    String nombre;
    String apellido;
    int edad;
    List<Sintoma> sintomas = new ArrayList<>();
}

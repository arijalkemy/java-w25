package ejercicio.caloriascalcu.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ingrediente {
     String nombre;
     int gramos;
     //double cantidadDeGramosUtilizados;
}

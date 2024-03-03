package Calorias.dto;
import Calorias.entity.Ingredientes;
import Calorias.entity.IngredientesPlato;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DtoPlato {
    private String nombre;
    private int calorias;
    private List<Ingredientes> ingredientes;
    private Ingredientes mayorCalorias;
}

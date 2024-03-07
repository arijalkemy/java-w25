package bootcamp.springejerciciospracticosp2vivo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {

    private String name;
    private Double calories;

}

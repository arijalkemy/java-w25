package bootcamp.springejerciciospracticosp2vivo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plate {

    private String name;
    private List<String> ingredients;

}

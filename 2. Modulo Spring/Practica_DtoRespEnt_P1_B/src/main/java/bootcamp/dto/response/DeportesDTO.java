package bootcamp.dto.response;

import bootcamp.models.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeportesDTO {
    List<Deporte> listDeportes;


}

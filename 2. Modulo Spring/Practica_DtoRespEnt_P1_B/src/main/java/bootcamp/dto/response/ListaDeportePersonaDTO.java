package bootcamp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListaDeportePersonaDTO {

    List<DeportePersonaDTO> lista;
}

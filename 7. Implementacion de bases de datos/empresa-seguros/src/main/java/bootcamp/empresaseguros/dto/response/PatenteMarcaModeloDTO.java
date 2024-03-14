package bootcamp.empresaseguros.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatenteMarcaModeloDTO extends PatenteMarcaDTO {

    String modelo;

}

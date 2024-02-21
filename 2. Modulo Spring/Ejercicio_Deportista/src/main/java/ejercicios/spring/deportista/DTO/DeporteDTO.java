package ejercicios.spring.deportista.DTO;

import ejercicios.spring.deportista.Model.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeporteDTO {
    private List<Deporte> sportsList;
    private String msg;
}

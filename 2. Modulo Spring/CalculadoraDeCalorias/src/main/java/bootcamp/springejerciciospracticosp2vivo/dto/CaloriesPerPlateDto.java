package bootcamp.springejerciciospracticosp2vivo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaloriesPerPlateDto {

    private List<PlateTotalCaloriesDto> caloriesPerPlate;

}

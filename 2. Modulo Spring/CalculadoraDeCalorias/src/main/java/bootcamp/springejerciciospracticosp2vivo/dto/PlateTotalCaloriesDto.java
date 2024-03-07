package bootcamp.springejerciciospracticosp2vivo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlateTotalCaloriesDto {

    private String name;
    private Double calories;

}
